package cn.wolfcode.edu.service;

import cn.wolfcode.edu.domain.Salary;
import cn.wolfcode.edu.query.PageResult;
import cn.wolfcode.edu.query.QueryObject;

import java.util.List;

public interface ISalaryService {

    void deleteByPrimaryKey(Long id);

    void insert(Salary record);

    Salary selectByPrimaryKey(Long id);

    List<Salary> selectAll();

    void updateByPrimaryKey(Salary record);

    PageResult query(QueryObject qo);

    Salary queryByIdentifier(Long id);
}
