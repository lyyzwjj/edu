package cn.wolfcode.edu.service;

import cn.wolfcode.edu.domain.Employee;

import java.util.List;

/**
 * Created by WangZhe on 2018/7/10.
 */
public interface IEmployeeService {
    /**
     * 返回所有员工
     * @return  员工列表
     */
    List<Employee> list();
}
