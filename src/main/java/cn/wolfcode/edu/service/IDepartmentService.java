package cn.wolfcode.edu.service;

import cn.wolfcode.edu.domain.Department;
import cn.wolfcode.edu.query.DepartmentQueryObject;
import cn.wolfcode.edu.query.PageResult;

import java.util.List;

public interface IDepartmentService {
    void save(Department entity);

    void delete (Long id);

    void update(Department entity);

    Department get(Long id);

    List<Department> list();

    //改变状态
    void changeState(Long id);

    PageResult query(DepartmentQueryObject qo);
}
