package cn.wolfcode.edu.mapper;

import cn.wolfcode.edu.domain.Department;
import cn.wolfcode.edu.query.QueryObject;

import java.util.List;

public interface DepartmentMapper {
    void deleteByPrimaryKey(Long id);

    void insert(Department record);

    Department selectByPrimaryKey(Long id);

    List<Department> selectAll();

    void updateByPrimaryKey(Department record);

    //改变状态
    void changeState(Long id);
    //分页
    int queryForCount(QueryObject qo);

    List<Department> queryForList(QueryObject qo);
}