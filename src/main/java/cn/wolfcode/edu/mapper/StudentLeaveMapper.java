package cn.wolfcode.edu.mapper;

import cn.wolfcode.edu.domain.StudentLeave;
import cn.wolfcode.edu.query.QueryObject;

import java.util.List;

public interface StudentLeaveMapper {
    int deleteByPrimaryKey(Long id);

    int insert(StudentLeave record);

    StudentLeave selectByPrimaryKey(Long id);

    List<StudentLeave> selectAll();

    int updateByPrimaryKey(StudentLeave record);



    //分页
    int queryForCount(QueryObject qo);

    List<StudentLeave> queryForList(QueryObject qo);

    void changeState(Long id);
}