package cn.wolfcode.edu.service;

import cn.wolfcode.edu.domain.CourseName;
import cn.wolfcode.edu.query.CourseNameQueryObject;
import cn.wolfcode.edu.query.PageResult;

import java.util.List;

public interface ICourseNameService {

    void save(CourseName courseName);

    CourseName get(Long id);

    List<CourseName> list();

    /**
     * 高级查询
     * @param qo
     * @return
     */
    PageResult query(CourseNameQueryObject qo);

    /**
     * 根据课程id更改是否会员课程状态
     * @param id
     */
    void changeState(Long id);
}
