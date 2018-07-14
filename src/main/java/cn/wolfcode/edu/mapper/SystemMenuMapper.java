package cn.wolfcode.edu.mapper;

import cn.wolfcode.edu.domain.SystemMenu;
import cn.wolfcode.edu.query.QueryObject;

import java.util.List;

public interface SystemMenuMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SystemMenu record);

    SystemMenu selectByPrimaryKey(Long id);

    List<SystemMenu> selectAll();

    int updateByPrimaryKey(SystemMenu record);

    int queryForCount(QueryObject qo);

    List<SystemMenu> queryForList(QueryObject qo);

    List<SystemMenu> queryAllParentSystemMenu();

    List<SystemMenu> queryRootMenu();
}