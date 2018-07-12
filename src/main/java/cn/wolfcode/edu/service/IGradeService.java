package cn.wolfcode.edu.service;

import cn.wolfcode.edu.domain.Grade;
import cn.wolfcode.edu.query.GradeQueryObject;
import cn.wolfcode.edu.query.PageResult;

import java.util.List;

public interface IGradeService {

    void save(Grade grade);

    void update(Grade grade);

    void delete(Long id);

    Grade get(Long id);

    List<Grade> list();

    /**
     * 高级查询
     * @param qo
     * @return
     */
    PageResult query(GradeQueryObject qo);

    /**
     * 根据班级id更改班级状态
     * @param id
     */
    void changeState(Long id);
}
