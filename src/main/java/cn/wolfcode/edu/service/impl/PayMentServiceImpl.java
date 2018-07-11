package cn.wolfcode.edu.service.impl;

import cn.wolfcode.edu.domain.ExpendBill;
import cn.wolfcode.edu.domain.PayMent;
import cn.wolfcode.edu.mapper.ExpendBillMapper;
import cn.wolfcode.edu.mapper.PayMentMapper;
import cn.wolfcode.edu.query.PageResult;
import cn.wolfcode.edu.query.QueryObject;
import cn.wolfcode.edu.service.IExpendBillService;
import cn.wolfcode.edu.service.IPayMentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by WangZhe on 2018/7/10.
 */
@Service
public class PayMentServiceImpl implements IPayMentService {
    @Autowired
    private PayMentMapper payMentMapper;

    @Override
    public PayMent get(Long id) {
        return payMentMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<PayMent> list() {
        return payMentMapper.selectAll();
    }

}
