package cn.wolfcode.edu.service.impl;

import cn.wolfcode.edu.domain.SystemMenu;
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
public class SystemMenuServiceImpl implements ISystemMenuService{
    @Autowired
    private SystemMenuMapper systemMenuMapper;


    @Override
    public void delete(Long id) {
        systemMenuMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void save(SystemMenu entity) {
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
}
