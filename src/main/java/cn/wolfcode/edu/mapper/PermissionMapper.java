package cn.wolfcode.edu.mapper;

import cn.wolfcode.edu.domain.Permission;
import cn.wolfcode.edu.query.QueryObject;

import java.util.List;

public interface PermissionMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Permission record);

    Permission selectByPrimaryKey(Long id);

    List<Permission> selectAll();

    int updateByPrimaryKey(Permission record);

    //分页
    int queryForCount(QueryObject qo);

    List<Permission> queryForList(QueryObject qo);

    List<Permission> queryPermissionByRoleId(Long roleId);

    List<String> selectAllResourcesByEmployeeId(Long id);

    List<Permission> queryIndexPermission();

}