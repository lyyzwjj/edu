package cn.wolfcode.edu.service;

import cn.wolfcode.edu.domain.Employee;
import cn.wolfcode.edu.query.PageResult;
import cn.wolfcode.edu.query.QueryObject;

import java.util.List;

public interface IEmployeeService {
    /**
     * 删除员工
     * @param id 待删除员工的id
     */
    void delete(Long id);

    /**
     * 添加员工
     * @param record
     */
    void save(Employee record);

    /**
     * 查询单个员工
     * @param id  待查询员工的id
     * @return
     */
    Employee get(Long id);

    /**
     * 查询所有的员工
     * @return
     */
    List<Employee> list();

    /**
     * 更新员工
     * @param record
     */
    void update(Employee record);

    /**
     * 查询到分页结果集
     * @param qo 查询参数对象
     * @return
     */
    PageResult query(EmployeeQueryObject qo);

    /**
     * 操作员工的离职或复值
     * @param id  待离职或复职的员工id
     */
    void changeState(Long id);
}
