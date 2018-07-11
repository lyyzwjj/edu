package cn.wolfcode.edu.service;

import cn.wolfcode.edu.domain.Employee;
import cn.wolfcode.edu.domain.ExpendBill;
import cn.wolfcode.edu.query.PageResult;
import cn.wolfcode.edu.query.QueryObject;

import java.util.List;

/**
 * Created by WangZhe on 2018/7/10.
 */
public interface IExpendBillService {
    int deleteByPrimaryKey(Long id);

    int insert(ExpendBill record);

    ExpendBill selectByPrimaryKey(Long id);

    List<ExpendBill> selectAll();

    int updateByPrimaryKey(ExpendBill record);

    /**
     * 分页查询的结果集
     * @param qo
     * @return
     */
    PageResult query(QueryObject qo);
}
