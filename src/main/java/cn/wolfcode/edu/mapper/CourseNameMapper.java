package cn.wolfcode.edu.mapper;

import cn.wolfcode.edu.domain.CourseName;
import cn.wolfcode.edu.query.CourseNameQueryObject;

import java.util.List;

public interface CourseNameMapper {

    int insert(CourseName record);

    CourseName selectByPrimaryKey(Long id);

    List<CourseName> selectAll();

    int queryForCount(CourseNameQueryObject qo);

    List<CourseName> queryForList(CourseNameQueryObject qo);

    void changeState(Long id);

    List<Long> queryCourseIdsByGradeId(Long gradeId);
}