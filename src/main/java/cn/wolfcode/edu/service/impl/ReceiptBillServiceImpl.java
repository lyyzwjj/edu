package cn.wolfcode.edu.service.impl;

import cn.wolfcode.edu.domain.Employee;
import cn.wolfcode.edu.domain.ReceiptBill;
import cn.wolfcode.edu.domain.StudentReceiptGather;
import cn.wolfcode.edu.mapper.ReceiptBillMapper;
import cn.wolfcode.edu.mapper.StudentReceiptGatherMapper;
import cn.wolfcode.edu.query.PageResult;
import cn.wolfcode.edu.query.QueryObject;
import cn.wolfcode.edu.service.IReceiptBillService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Created by WangZhe on 2018/7/10.
 */
@Service
public class ReceiptBillServiceImpl implements IReceiptBillService{
    @Autowired
    private ReceiptBillMapper receiptBillMapper;
    @Autowired
    private StudentReceiptGatherMapper studentReceiptGatherMapper;

    @Override
    public int delete(Long id) {
        return receiptBillMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int save(ReceiptBill record) {
        Date date = new Date();
        record.setReceipttime(date);

        BigDecimal totalmoney = record.getTotalmoney();
        BigDecimal unpaidmoney = totalmoney;
        Long id = record.getClient().getId();
        List<ReceiptBill> receiptBills = receiptBillMapper.selectBillsByClientId(id);
        StudentReceiptGather studentReceiptGather =  studentReceiptGatherMapper.selectByClientId();
        if (receiptBills == null){
            unpaidmoney = totalmoney.subtract(record.getReceiptmoney());
            studentReceiptGather.setTotalmoney(record.getTotalmoney());
            studentReceiptGather.setTotalreceiptmoney(record.getReceiptmoney());
            studentReceiptGather.setUnpaidmoney(unpaidmoney);
            studentReceiptGatherMapper.insert(studentReceiptGather);
        }else{
            for (ReceiptBill bill : receiptBills) {
                unpaidmoney = unpaidmoney.subtract(bill.getReceiptmoney());

            }
            studentReceiptGather.setTotalmoney(record.getTotalmoney());
            studentReceiptGather.setTotalreceiptmoney(record.getReceiptmoney());
            studentReceiptGather.setUnpaidmoney(unpaidmoney);
            studentReceiptGatherMapper.insert(studentReceiptGather);
        }
        if (unpaidmoney == null){
            unpaidmoney = BigDecimal.ZERO;
        }
        record.setReceiptmoney(unpaidmoney);
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

    @Override
    public void check(Long id) {
        ReceiptBill receiptBill = receiptBillMapper.selectByPrimaryKey(id);
        if (receiptBill != null){
            if (receiptBill.getState() == 0){
                //审核人还没设置
                Employee currentUser = (Employee) SecurityUtils.getSubject();
                receiptBill.setState(1);
                receiptBill.getAuditor().setId(currentUser.getId());
                receiptBillMapper.updateByPrimaryKey(receiptBill);
            }
        }
    }
}
