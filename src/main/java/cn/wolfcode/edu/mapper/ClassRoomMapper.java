package cn.wolfcode.edu.mapper;

import cn.wolfcode.edu.domain.ClassRoom;
import cn.wolfcode.edu.query.QueryObject;

import java.util.List;

public interface ClassRoomMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ClassRoom record);

    ClassRoom selectByPrimaryKey(Long id);

    List<ClassRoom> selectAll();

    int updateByPrimaryKey(ClassRoom record);

    int queryForCount(QueryObject qo);

    List<ClassRoom> queryForList(QueryObject qo);
}