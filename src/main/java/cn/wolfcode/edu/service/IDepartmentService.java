package cn.wolfcode.edu.service;

import cn.wolfcode.edu.domain.Department;
import cn.wolfcode.edu.query.PageResult;
import cn.wolfcode.edu.query.QueryObject;

import java.util.List;

public interface IDepartmentService {
    void save(Department entity);

    void delete (Long id);

    void update(Department entity);

    Department get(Long id);

    List<Department> list();

    PageResult query(QueryObject qo);
}
