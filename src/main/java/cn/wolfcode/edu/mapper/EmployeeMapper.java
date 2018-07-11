package cn.wolfcode.edu.mapper;

import cn.wolfcode.edu.domain.Employee;
import cn.wolfcode.edu.query.QueryObject;

import java.util.List;

public interface EmployeeMapper {

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
     * 分页条数
     * @param qo  封装的查询条件对象
     * @return
     */
    int queryForCount(QueryObject qo);

    /**
     * 分页对象集合
     * @param qo  封装的查询条件对象
     * @return
     */
    List<Employee> queryForList(QueryObject qo);


}