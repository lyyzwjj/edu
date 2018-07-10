package cn.wolfcode.edu.service.impl;

import cn.wolfcode.edu.domain.Employee;
import cn.wolfcode.edu.mapper.EmployeeMapper;
import cn.wolfcode.edu.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by WangZhe on 2018/7/10.
 */
@Service
public class EmployeeServiceImpl implements IEmployeeService{
    @Autowired
    private EmployeeMapper employeeMapper;
    @Override
    public List<Employee> list() {
        return employeeMapper.selectAll();
    }
}
