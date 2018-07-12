package cn.wolfcode.edu.service.impl;

import cn.wolfcode.edu.domain.CourseName;
import cn.wolfcode.edu.mapper.CourseNameMapper;
import cn.wolfcode.edu.query.CourseNameQueryObject;
import cn.wolfcode.edu.query.PageResult;
import cn.wolfcode.edu.service.ICourseNameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseNameServiceImpl implements ICourseNameService{
    @Autowired
    private CourseNameMapper courseNameMapper;

    public void save(CourseName courseName) {

        //设置初始状态为非会员课程
        courseName.setState(CourseName.STATE_NORMAL);

        courseNameMapper.insert(courseName);

    }


    public CourseName get(Long id) {
        return courseNameMapper.selectByPrimaryKey(id);
    }

    public List<CourseName> list() {
        return courseNameMapper.selectAll();
    }

    public PageResult query(CourseNameQueryObject qo) {
        int total = courseNameMapper.queryForCount(qo);
        if(total ==0){
            return new PageResult();
        }
        List<CourseName> rows = courseNameMapper.queryForList(qo);
        return new PageResult(total,rows);
    }

    public void changeState(Long id) {
        courseNameMapper.changeState(id);
    }

}
