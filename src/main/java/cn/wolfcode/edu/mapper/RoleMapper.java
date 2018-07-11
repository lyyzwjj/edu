package cn.wolfcode.edu.mapper;

import cn.wolfcode.edu.domain.Role;
import cn.wolfcode.edu.query.QueryObject;

import java.util.List;

public interface RoleMapper {
    void deleteByPrimaryKey(Long id);

    void insert(Role record);

    Role selectByPrimaryKey(Long id);

    List<Role> selectAll();

    void updateByPrimaryKey(Role record);

    int queryForCount(QueryObject qo);

    List<Role> queryForList(QueryObject qo);
}