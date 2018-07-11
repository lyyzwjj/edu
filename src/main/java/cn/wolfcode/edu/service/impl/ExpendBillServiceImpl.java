package cn.wolfcode.edu.service.impl;

import cn.wolfcode.edu.domain.ExpendBill;
import cn.wolfcode.edu.mapper.ExpendBillMapper;
import cn.wolfcode.edu.query.PageResult;
import cn.wolfcode.edu.query.QueryObject;
import cn.wolfcode.edu.service.IExpendBillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by WangZhe on 2018/7/10.
 */
@Service
public class ExpendBillServiceImpl implements IExpendBillService{
    @Autowired
    private ExpendBillMapper expendBillMapper;


    @Override
    public int deleteByPrimaryKey(Long id) {
        return expendBillMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(ExpendBill record) {
        return expendBillMapper.insert(record);
    }

    @Override
    public ExpendBill selectByPrimaryKey(Long id) {
        return expendBillMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<ExpendBill> selectAll() {
        return expendBillMapper.selectAll();
    }

    @Override
    public int updateByPrimaryKey(ExpendBill record) {
        return expendBillMapper.updateByPrimaryKey(record);
    }

    @Override
    public PageResult query(QueryObject qo) {
        int total = expendBillMapper.queryForCount(qo);
        if (total == 0){
            return new PageResult();
        }
        List<ExpendBill> rows = expendBillMapper.queryForList(qo);
        return new PageResult(total,rows);
    }
}
