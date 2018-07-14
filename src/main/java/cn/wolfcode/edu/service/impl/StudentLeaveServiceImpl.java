package cn.wolfcode.edu.service.impl;

import cn.wolfcode.edu.domain.StudentLeave;
import cn.wolfcode.edu.mapper.ClientMapper;
import cn.wolfcode.edu.mapper.StudentLeaveMapper;
import cn.wolfcode.edu.query.QueryObject;
import cn.wolfcode.edu.query.PageResult;
import cn.wolfcode.edu.service.IStudentLeaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentLeaveServiceImpl implements IStudentLeaveService{
    @Autowired
    private StudentLeaveMapper studentLeaveMapper;
    @Autowired
    private ClientMapper clientMapper;

    public void save(StudentLeave entity) {

        studentLeaveMapper.insert(entity);

        clientMapper.changeState(entity.getClient().getId(),4);
    }

    public void update(StudentLeave entity) {
        studentLeaveMapper.updateByPrimaryKey(entity);
    }

    public void delete(Long id) {
        studentLeaveMapper.deleteByPrimaryKey(id);
    }

    public StudentLeave get(Long id) {
        return studentLeaveMapper.selectByPrimaryKey(id);
    }

    public List<StudentLeave> list() {
        return studentLeaveMapper.selectAll();
    }

    public void changeState(Long id){
        StudentLeave studentLeave = studentLeaveMapper.selectByPrimaryKey(id);
        studentLeave.setState(1);
        studentLeaveMapper.updateByPrimaryKey(studentLeave);
    }

    public PageResult query(QueryObject qo) {
        int total = studentLeaveMapper.queryForCount(qo);
        if(total ==0){
            return new PageResult();
        }
        List<StudentLeave> rows = studentLeaveMapper.queryForList(qo);
        return new PageResult(total,rows);
    }

}
