package cn.wolfcode.edu.service.impl;

import cn.wolfcode.edu.domain.CourseName;
import cn.wolfcode.edu.domain.Grade;
import cn.wolfcode.edu.mapper.GradeMapper;
import cn.wolfcode.edu.query.GradeQueryObject;
import cn.wolfcode.edu.query.PageResult;
import cn.wolfcode.edu.service.IGradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GradeServiceImpl implements IGradeService{
    @Autowired
    private GradeMapper gradeMapper;

    public void save(Grade grade) {

        //设置初始状态为可用
        grade.setState(Grade.STATE_NORMAL);

        gradeMapper.insert(grade);

        //维护关系
        List<CourseName> courseNames = grade.getCourseName();
        if(courseNames !=null){
            for (CourseName courseName : courseNames) {
                gradeMapper.insertCourseRelation(grade.getId(),courseName.getId());
            }
        }
    }

    public void update(Grade grade) {
        //删除关系
        gradeMapper.deleteCourseRelation(grade.getId());
        gradeMapper.updateByPrimaryKey(grade);
        //维护关系
        List<CourseName> courseNames = grade.getCourseName();
        if(courseNames !=null){
            for (CourseName courseName : courseNames) {
                gradeMapper.insertCourseRelation(grade.getId(),courseName.getId());
            }
        }

    }

    public void delete(Long id) {
        //删除关系
        gradeMapper.deleteCourseRelation(id);
        gradeMapper.deleteByPrimaryKey(id);
    }

    public Grade get(Long id) {
        return gradeMapper.selectByPrimaryKey(id);
    }

    public List<Grade> list() {
        return gradeMapper.selectAll();
    }

    public PageResult query(GradeQueryObject qo) {
        int total = gradeMapper.queryForCount(qo);
        if(total ==0){
            return new PageResult();
        }
        List<Grade> rows = gradeMapper.queryForList(qo);
        return new PageResult(total,rows);
    }

    public void changeState(Long id) {
        gradeMapper.changeState(id);
    }

}
