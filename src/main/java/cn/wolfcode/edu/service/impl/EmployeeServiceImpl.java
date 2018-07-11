package cn.wolfcode.edu.service.impl;

import cn.wolfcode.edu.domain.Employee;
import cn.wolfcode.edu.mapper.EmployeeMapper;
import cn.wolfcode.edu.query.EmployeeQueryObject;
import cn.wolfcode.edu.query.PageResult;
import cn.wolfcode.edu.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements IEmployeeService{
    @Autowired
    private EmployeeMapper employeeMapper;

    public void delete(Long id) {
        employeeMapper.deleteByPrimaryKey(id);
    }

    public void save(Employee record) {
        employeeMapper.insert(record);
    }

    public Employee get(Long id) {
        return employeeMapper.selectByPrimaryKey(id);
    }

    public List<Employee> list() {
        return employeeMapper.selectAll();
    }

    public void update(Employee record) {
        employeeMapper.updateByPrimaryKey(record);
    }

    public PageResult query(EmployeeQueryObject qo) {
        //查询总条数
        int total = employeeMapper.queryForCount(qo);
        if(total ==0){
            return new PageResult();
        }
        //查询分页数据
        List<Employee> rows = employeeMapper.queryForList(qo);
        return new PageResult(total, rows);
    }

    public void changeState(Long id) {
        employeeMapper.changeState(id);
    }
}
