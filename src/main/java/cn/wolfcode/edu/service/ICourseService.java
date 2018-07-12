package cn.wolfcode.edu.service;

import cn.wolfcode.edu.domain.Course;
import cn.wolfcode.edu.query.PageResult;
import cn.wolfcode.edu.query.QueryObject;

import java.util.List;

public interface ICourseService {

    void save(Course course);

    void update(Course course);

    void delete(Long id);

    Course get(Long id);

    List<Course> list();

    /**
     * 高级查询
     * @param qo
     * @return
     */
    PageResult query(QueryObject qo);

    /**
     * 根据班级id更改班级状态
     * @param id
     */
    void changeState(Long id);

    /**
     * 根据班级id查询课程表
     * @param gradeId
     * @return
     */
    List<Long> queryCourseIdsByGradeId(Long gradeId);
}
