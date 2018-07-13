package cn.wolfcode.edu.service;

import cn.wolfcode.edu.domain.StudentTrend;
import cn.wolfcode.edu.query.QueryObject;
import cn.wolfcode.edu.query.PageResult;

import java.util.List;

public interface IStudentTrendService {
    void save(StudentTrend entity);

    void delete(Long id);

    void update(StudentTrend entity);

    StudentTrend get(Long id);

    List<StudentTrend> list();

    /**
     * 根据id将潜在学员转正
     * @return
     */
    void changeState(Long id,int stateId);

    PageResult query(QueryObject qo);
}
