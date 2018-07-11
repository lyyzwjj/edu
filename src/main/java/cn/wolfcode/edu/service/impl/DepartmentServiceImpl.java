package cn.wolfcode.edu.service.impl;

import cn.wolfcode.edu.domain.Department;
import cn.wolfcode.edu.mapper.DepartmentMapper;
import cn.wolfcode.edu.query.DepartmentQueryObject;
import cn.wolfcode.edu.query.PageResult;
import cn.wolfcode.edu.service.IDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements IDepartmentService{
    @Autowired
    private DepartmentMapper departmentMapper;

    public void save(Department entity) {
        departmentMapper.insert(entity);
    }

    public void update(Department entity) {
        departmentMapper.updateByPrimaryKey(entity);
    }

    public void delete(Long id) {
        departmentMapper.deleteByPrimaryKey(id);
    }

    public Department get(Long id) {
        return departmentMapper.selectByPrimaryKey(id);
    }

    public List<Department> list() {
        return departmentMapper.selectAll();
    }

    public void changeState(Long id){
         departmentMapper.changeState(id);
    }
    public PageResult query(DepartmentQueryObject qo) {
        int total = departmentMapper.queryForCount(qo);
        if(total ==0){
            return new PageResult();
        }
        List<Department> rows = departmentMapper.queryForList(qo);
        return new PageResult(total,rows);
    }

}
