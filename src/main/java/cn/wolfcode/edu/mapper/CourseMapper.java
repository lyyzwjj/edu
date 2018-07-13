package cn.wolfcode.edu.mapper;

import cn.wolfcode.edu.domain.Course;
import cn.wolfcode.edu.query.CourseQueryObject;

import java.util.Date;
import java.util.List;

public interface CourseMapper {

    Course selectByPrimaryKey(Long id);

    List<Course> selectAll();

    int queryForCount(CourseQueryObject qo);

    List<Course> queryForList(CourseQueryObject qo);

    void updateByPrimaryKey(Course course);

    List<Course> querytodayByDate(Date date);
}