package cn.wolfcode.edu.service;

import cn.wolfcode.edu.domain   .Permission;
import cn.wolfcode.edu.query.PageResult;
import cn.wolfcode.edu.query.QueryObject;

import java.util.List;

public interface IPermissionService {
    void save(Permission entity);

    void delete(Long id);

    void update(Permission entity);

    Permission get(Long id);

    List<Permission> list();
    
    PageResult query(QueryObject qo);

    void reload();
}
