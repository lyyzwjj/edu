package cn.wolfcode.edu.service.impl;

import cn.wolfcode.edu.domain.Permission;
import cn.wolfcode.edu.mapper.PermissionMapper;
import cn.wolfcode.edu.query.PageResult;
import cn.wolfcode.edu.query.QueryObject;
import cn.wolfcode.edu.service.IPermissionService;
import cn.wolfcode.edu.util.PermissionName;
import org.apache.ibatis.scripting.xmltags.ForEachSqlNode;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.util.*;

@Service
public class PermissionServiceImpl implements IPermissionService{
    @Autowired
    private PermissionMapper permissionMapper;
    @Autowired
    private RequestMappingHandlerMapping rmhm;
    public void save(Permission entity) {
        permissionMapper.insert(entity);

    }

    public void update(Permission entity) {
        permissionMapper.updateByPrimaryKey(entity);
    }

    public void delete(Long id) {
        permissionMapper.deleteByPrimaryKey(id);
    }

    public Permission get(Long id) {
        return permissionMapper.selectByPrimaryKey(id);
    }

    public List<Permission> list() {
        return permissionMapper.selectAll();
    }

    public PageResult query(QueryObject qo) {
        int total = permissionMapper.queryForCount(qo);
        if(total ==0){
            return new PageResult();
        }
        List<Permission> rows = permissionMapper.queryForList(qo);
        return new PageResult(total,rows);
    }
    public void reload(){
        //排重
        List<Permission> permissions = permissionMapper.selectAll();
        Set<String> set = new HashSet<>();
        for (Permission s : permissions) {
            set.add(s.getResource());
        }
        Map<RequestMappingInfo, HandlerMethod> handlerMethods = rmhm.getHandlerMethods();
        Collection<HandlerMethod> values = handlerMethods.values();
        for (HandlerMethod hm : values) {
            RequiresPermissions ann = hm.getMethodAnnotation(RequiresPermissions.class);
            if(ann==null){
                continue;
            }
            String resource = ann.value()[0];
            //如果加载了权限就跳过
            if(set.contains(resource)){
                continue;
            }
            //获取权限名称
            PermissionName pn = hm.getMethodAnnotation(PermissionName.class);
            String name = pn.value();
            //获取权限表示式然后封装
            Permission permission = new Permission();
            permission.setName(name);
            permission.setResource(resource);
            permissionMapper.insert(permission);
        }
    }

    public List<Permission> queryPermissionByRoleId(Long roleId) {
        return permissionMapper.queryPermissionByRoleId(roleId);
    }
    @Override
    public List<String> selectAllResourcesByEmployeeId(Long id) {
        return permissionMapper.selectAllResourcesByEmployeeId(id);
    }
}
