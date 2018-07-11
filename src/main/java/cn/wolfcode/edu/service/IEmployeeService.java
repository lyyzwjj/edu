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
    void deleteByPrimaryKey(Long id);

    /**
     * 添加员工
     * @param record
     */
    void insert(Employee record);

    /**
     * 查询单个员工
     * @param id  待查询员工的id
     * @return
     */
    Employee selectByPrimaryKey(Long id);

    /**
     * 查询所有的员工
     * @return
     */
    List<Employee> selectAll();

    /**
     * 更新员工
     * @param record
     */
    void updateByPrimaryKey(Employee record);

    /**
     * 查询到分页结果集
     * @param qo 查询参数对象
     * @return
     */
    PageResult query(QueryObject qo);
}
