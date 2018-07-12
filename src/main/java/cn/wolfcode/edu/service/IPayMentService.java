package cn.wolfcode.edu.service;

import cn.wolfcode.edu.domain.ExpendBill;
import cn.wolfcode.edu.domain.PayMent;
import cn.wolfcode.edu.query.PageResult;
import cn.wolfcode.edu.query.QueryObject;

import java.util.List;

/**
 * Created by WangZhe on 2018/7/10.
 */
public interface IPayMentService {

    PayMent get(Long id);

    List<PayMent> list();
}
