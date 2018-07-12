package cn.wolfcode.edu.service.impl;

import cn.wolfcode.edu.domain.Employee;
import cn.wolfcode.edu.domain.Role;
import cn.wolfcode.edu.mapper.EmployeeMapper;
import cn.wolfcode.edu.query.EmployeeQueryObject;
import cn.wolfcode.edu.query.PageResult;
import cn.wolfcode.edu.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements IEmployeeService {
    @Autowired
    private EmployeeMapper employeeMapper;

    public void delete(Long id) {
        //先删除员工
        employeeMapper.deleteByPrimaryKey(id);
        //再删除员工和角色的关系
        employeeMapper.deleteRelation(id);
    }

    public void save(Employee record) {
        //先保存员工
        employeeMapper.insert(record);
        //再保存员工和角色的关系
        List<Role> roles = record.getRoles();
        if (roles != null) {
            for (Role role : roles) {
                employeeMapper.insertRelation(record.getId(), role.getId());
            }
        }
    }

    public Employee get(Long id) {
        return employeeMapper.selectByPrimaryKey(id);
    }

    public List<Employee> list() {
        return employeeMapper.selectAll();
    }

    public void update(Employee record) {
        //先删除关系
        employeeMapper.deleteRelation(record.getId());
        //再保存关系
        List<Role> roles = record.getRoles();
        if (roles != null) {
            for (Role role : roles) {
                employeeMapper.insertRelation(record.getId(), role.getId());
            }
        }
        //再更新
        employeeMapper.updateByPrimaryKey(record);
    }

    public PageResult query(EmployeeQueryObject qo) {
        //查询总条数
        int total = employeeMapper.queryForCount(qo);
        if (total == 0) {
            return new PageResult();
        }
        //查询分页数据
        List<Employee> rows = employeeMapper.queryForList(qo);
        return new PageResult(total, rows);
    }

    public void changeState(Long id) {
        employeeMapper.changeState(id);
    }

    public void uploadPortrait(Long staff_id, String upload) {
        employeeMapper.uploadPortrait(staff_id,upload);
    }
}
