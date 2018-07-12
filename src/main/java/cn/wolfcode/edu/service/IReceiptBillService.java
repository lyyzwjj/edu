package cn.wolfcode.edu.service;

import cn.wolfcode.edu.domain.ReceiptBill;
import cn.wolfcode.edu.domain.PayMent;
import cn.wolfcode.edu.query.PageResult;
import cn.wolfcode.edu.query.QueryObject;

import java.util.List;

/**
 * Created by WangZhe on 2018/7/10.
 */
public interface IReceiptBillService {

    int delete(Long id);

    int save(ReceiptBill record);

    ReceiptBill get(Long id);

    List<ReceiptBill> list();

    int update(ReceiptBill record);

    /**
     * 分页查询的结果集
     * @param qo
     * @return
     */
    PageResult query(QueryObject qo);

    //审核
    void check(Long id);
}
