package cn.wolfcode.edu.service.impl;

import cn.wolfcode.edu.domain.Employee;
import cn.wolfcode.edu.mapper.EmployeeMapper;
import cn.wolfcode.edu.query.PageResult;
import cn.wolfcode.edu.query.QueryObject;
import cn.wolfcode.edu.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements IEmployeeService{
    @Autowired
    private EmployeeMapper employeeMapper;

    public void deleteByPrimaryKey(Long id) {
        employeeMapper.deleteByPrimaryKey(id);
    }

    public void insert(Employee record) {
        employeeMapper.insert(record);
    }

    public Employee selectByPrimaryKey(Long id) {
        return employeeMapper.selectByPrimaryKey(id);
    }

    public List<Employee> selectAll() {
        return employeeMapper.selectAll();
    }

    public void updateByPrimaryKey(Employee record) {
        employeeMapper.updateByPrimaryKey(record);
    }

    public PageResult query(QueryObject qo) {
        //查询总条数
        int total = employeeMapper.queryForCount(qo);
        //查询分页数据
        List<Employee> rows = employeeMapper.queryForList(qo);
        return new PageResult(total, rows);
    }
}
