package cn.wolfcode.edu.service.impl;

import cn.wolfcode.edu.domain.Salary;
import cn.wolfcode.edu.mapper.SalaryMapper;
import cn.wolfcode.edu.query.PageResult;
import cn.wolfcode.edu.query.QueryObject;
import cn.wolfcode.edu.service.ISalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalaryServiceImpl implements ISalaryService {
    @Autowired
    private SalaryMapper salaryMapper;

    public void deleteByPrimaryKey(Long id) {
        salaryMapper.deleteByPrimaryKey(id);
    }

    public void insert(Salary record) {
        salaryMapper.insert(record);
    }

    public Salary selectByPrimaryKey(Long id) {
        return salaryMapper.selectByPrimaryKey(id);
    }

    public List<Salary> selectAll() {
        return salaryMapper.selectAll();
    }

    public void updateByPrimaryKey(Salary record) {
        salaryMapper.updateByPrimaryKey(record);
    }

    public PageResult query(QueryObject qo) {
        //查询总条数
        int total = salaryMapper.queryForCount(qo);
        if (total == 0) {
            return new PageResult();
        }
        //查询分页数据
        List<Salary> rows = salaryMapper.queryForList(qo);
        return new PageResult(total, rows);
    }

    public Salary queryByIdentifier(Long id) {
        return salaryMapper.queryByIdentifier(id);
    }
}
