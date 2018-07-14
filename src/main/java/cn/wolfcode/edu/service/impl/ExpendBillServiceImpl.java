package cn.wolfcode.edu.service.impl;

import cn.wolfcode.edu.domain.Employee;
import cn.wolfcode.edu.domain.ExpendBill;
import cn.wolfcode.edu.mapper.ExpendBillMapper;
import cn.wolfcode.edu.query.PageResult;
import cn.wolfcode.edu.query.QueryObject;
import cn.wolfcode.edu.service.IExpendBillService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by WangZhe on 2018/7/10.
 */
@Service
public class ExpendBillServiceImpl implements IExpendBillService{
    @Autowired
    private ExpendBillMapper expendBillMapper;


    @Override
    public int delete(Long id) {
        return expendBillMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int save(ExpendBill record) {

        Date payTime = new Date();
        record.setPayTime(payTime);
        record.setState(0);

        Employee currentUser = (Employee) SecurityUtils.getSubject();
        record.getCashier().setId(currentUser.getId());
        return expendBillMapper.insert(record);
    }

    @Override
    public ExpendBill get(Long id) {
        return expendBillMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<ExpendBill> list() {
        return expendBillMapper.selectAll();
    }

    @Override
    public int update(ExpendBill record) {
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

    @Override
    public void check(Long id) {
        ExpendBill expendBill = expendBillMapper.selectByPrimaryKey(id);
        if (expendBill != null){
            if (expendBill.getState() == 0){
                Employee currentUser = (Employee) SecurityUtils.getSubject();
                expendBill.getAuditor().setId(currentUser.getId());
                expendBill.setState(1);
                expendBillMapper.updateByPrimaryKey(expendBill);
            }
        }
    }
}
