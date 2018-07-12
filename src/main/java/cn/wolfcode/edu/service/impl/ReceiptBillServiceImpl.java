package cn.wolfcode.edu.service.impl;

import cn.wolfcode.edu.domain.ReceiptBill;
import cn.wolfcode.edu.mapper.ReceiptBillMapper;
import cn.wolfcode.edu.query.PageResult;
import cn.wolfcode.edu.query.QueryObject;
import cn.wolfcode.edu.service.IReceiptBillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by WangZhe on 2018/7/10.
 */
@Service
public class ReceiptBillServiceImpl implements IReceiptBillService{
    @Autowired
    private ReceiptBillMapper receiptBillMapper;


    @Override
    public int delete(Long id) {
        return receiptBillMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int save(ReceiptBill record) {
        return receiptBillMapper.insert(record);
    }

    @Override
    public ReceiptBill get(Long id) {
        return receiptBillMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<ReceiptBill> list() {
        return receiptBillMapper.selectAll();
    }

    @Override
    public int update(ReceiptBill record) {
        return receiptBillMapper.updateByPrimaryKey(record);
    }

    @Override
    public PageResult query(QueryObject qo) {
        int total = receiptBillMapper.queryForCount(qo);
        if (total == 0){
            return new PageResult();
        }
        List<ReceiptBill> rows = receiptBillMapper.queryForList(qo);
        return new PageResult(total,rows);
    }
}
