package cn.wolfcode.edu.mapper;

import cn.wolfcode.edu.domain.Department;
import cn.wolfcode.edu.query.QueryObject;

import java.util.List;

public interface DepartmentMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Department record);

    Department selectByPrimaryKey(Long id);

    List<Department> selectAll();

    int updateByPrimaryKey(Department record);

    //分页
    int queryForCount(QueryObject qo);

    List<Department> queryForList(QueryObject qo);
}