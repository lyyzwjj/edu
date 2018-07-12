package cn.wolfcode.edu.service.impl;

import cn.wolfcode.edu.domain.Course;
import cn.wolfcode.edu.mapper.CourseMapper;
import cn.wolfcode.edu.query.PageResult;
import cn.wolfcode.edu.query.QueryObject;
import cn.wolfcode.edu.service.ICourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements ICourseService{
    @Autowired
    private CourseMapper courseMapper;

    public void save(Course course) {

        //设置初始状态为可用
        course.setState(Course.STATE_NORMAL);

        courseMapper.insert(course);
    }

    public void update(Course course) {
        courseMapper.updateByPrimaryKey(course);
    }

    public void delete(Long id) {
        courseMapper.deleteByPrimaryKey(id);
    }

    public Course get(Long id) {
        return courseMapper.selectByPrimaryKey(id);
    }

    public List<Course> list() {
        return courseMapper.selectAll();
    }

    public PageResult query(QueryObject qo) {
        int total = courseMapper.queryForCount(qo);
        if(total ==0){
            return new PageResult();
        }
        List<Course> rows = courseMapper.queryForList(qo);
        return new PageResult(total,rows);
    }

    public void changeState(Long id) {
        courseMapper.changeState(id);
    }

    public List<Long> queryCourseIdsByGradeId(Long gradeId) {
        return courseMapper.queryCourseIdsByGradeId(gradeId);
    }

}
