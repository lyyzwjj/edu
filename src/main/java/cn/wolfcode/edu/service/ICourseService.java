package cn.wolfcode.edu.service;

import cn.wolfcode.edu.domain.Course;
import cn.wolfcode.edu.query.CourseQueryObject;
import cn.wolfcode.edu.query.PageResult;

import java.util.Date;
import java.util.List;

public interface ICourseService {

    Course get(Long id);

    List<Course> list();

    void update(Course course);

    /**
     * 高级查询
     * @param qo
     * @return
     */
    PageResult query(CourseQueryObject qo);


    /**
     * 根据时间查询符合条件的数据
     * @param date
     */
    List<Course> querytodayByDate(Date date);
}
