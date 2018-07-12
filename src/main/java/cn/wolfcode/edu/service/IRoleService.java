package cn.wolfcode.edu.service;

import cn.wolfcode.edu.domain.Role;
import cn.wolfcode.edu.query.PageResult;
import cn.wolfcode.edu.query.QueryObject;

import java.util.List;

public interface IRoleService {
    void save(Role entity);

    void delete(Long id);

    void update(Role entity);

    Role get(Long id);

    List<Role> list();
    
    PageResult query(QueryObject qo);

    List<Long> getRoleIdByEmpId(Long empId);
}
