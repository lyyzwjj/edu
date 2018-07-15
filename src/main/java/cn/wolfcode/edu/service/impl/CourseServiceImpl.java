package cn.wolfcode.edu.service.impl;

import cn.wolfcode.edu.domain.Course;
import cn.wolfcode.edu.mapper.CourseMapper;
import cn.wolfcode.edu.query.CourseQueryObject;
import cn.wolfcode.edu.query.PageResult;
import cn.wolfcode.edu.service.ICourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CourseServiceImpl implements ICourseService{
    @Autowired
    private CourseMapper courseMapper;

    public Course get(Long id) {
        return courseMapper.selectByPrimaryKey(id);
    }

    public List<Course> list() {
        return courseMapper.selectAll();
    }

    public void update(Course course) {
        courseMapper.updateByPrimaryKey(course);
    }

    public PageResult query(CourseQueryObject qo) {
        int total = courseMapper.queryForCount(qo);
        if(total ==0){
            return new PageResult();
        }
        List<Course> rows = courseMapper.queryForList(qo);
        return new PageResult(total,rows);
    }

    public List<Course> querytodayByDate(Date date) {
        return courseMapper.querytodayByDate(date);
    }

    public void save(Course course) {
        courseMapper.insert(course);
    }
}
