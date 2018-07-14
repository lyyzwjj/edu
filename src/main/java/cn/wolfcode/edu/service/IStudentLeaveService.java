package cn.wolfcode.edu.service;

import cn.wolfcode.edu.domain.StudentLeave;
import cn.wolfcode.edu.query.QueryObject;
import cn.wolfcode.edu.query.PageResult;

import java.util.List;

public interface IStudentLeaveService {
    void save(StudentLeave entity);

    void delete(Long id);

    void update(StudentLeave entity);

    StudentLeave get(Long id);

    List<StudentLeave> list();

    //改变状态
    void changeState(Long id);

    PageResult query(QueryObject qo);
}
