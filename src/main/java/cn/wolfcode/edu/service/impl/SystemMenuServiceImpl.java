package cn.wolfcode.edu.service.impl;

import cn.wolfcode.edu.domain.Permission;
import cn.wolfcode.edu.domain.SystemMenu;
import cn.wolfcode.edu.mapper.PermissionMapper;
import cn.wolfcode.edu.mapper.SystemMenuMapper;
import cn.wolfcode.edu.query.PageResult;
import cn.wolfcode.edu.query.QueryObject;
import cn.wolfcode.edu.service.ISystemMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by WangZhe on 2018/7/11.
 */
@Service
public class SystemMenuServiceImpl implements ISystemMenuService {
    @Autowired
    private SystemMenuMapper systemMenuMapper;
    @Autowired
    private PermissionMapper permissionMapper;


    @Override
    public void delete(Long id) {
        systemMenuMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void save(SystemMenu entity) {
        if ("".equals(entity.getUrl().trim())) {
            entity.setUrl(null);
        }
        if (entity.getPermission().getResource().contains(":index")) {
            String replace = entity.getPermission().getResource().replace(":index", "");
            entity.getPermission().setResource(replace);
        }
        systemMenuMapper.insert(entity);
    }

    @Override
    public SystemMenu get(Long id) {
        return systemMenuMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<SystemMenu> list() {
        return systemMenuMapper.selectAll();
    }

    @Override
    public void update(SystemMenu entity) {
        if ("".equals(entity.getUrl().trim())) {
            entity.setUrl(null);
        }
            if (entity.getPermission().getResource().contains(":index")) {
                String replace = entity.getPermission().getResource().replace(":index", "");
                entity.getPermission().setResource(replace);
            }
        systemMenuMapper.updateByPrimaryKey(entity);
    }

    @Override
    public PageResult query(QueryObject qo) {
        //查询总条数
        int total = systemMenuMapper.queryForCount(qo);
        //查询分页数据
        List<SystemMenu> rows = systemMenuMapper.queryForList(qo);
        return new PageResult(total, rows);
    }

    @Override
    public List<SystemMenu> queryAllParentSystemMenu() {
        return systemMenuMapper.queryAllParentSystemMenu();
    }

    @Override
    public List<SystemMenu> queryRootMenu() {
        return systemMenuMapper.queryRootMenu();
    }

    @Override
    public List<Permission> queryIndexPermission() {
        return permissionMapper.queryIndexPermission();
    }

}
