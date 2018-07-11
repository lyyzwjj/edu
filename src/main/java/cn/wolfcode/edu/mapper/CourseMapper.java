package cn.wolfcode.edu.mapper;

import cn.wolfcode.edu.domain.Course;
import cn.wolfcode.edu.query.QueryObject;

import java.util.List;

public interface CourseMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Course record);

    Course selectByPrimaryKey(Long id);

    List<Course> selectAll();

    int updateByPrimaryKey(Course record);

    int queryForCount(QueryObject qo);

    List<Course> queryForList(QueryObject qo);

    void changeState(Long id);

    List<Long> queryCourseIdsByGradeId(Long gradeId);
}