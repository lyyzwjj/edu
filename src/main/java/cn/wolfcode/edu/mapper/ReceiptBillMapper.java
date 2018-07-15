package cn.wolfcode.edu.mapper;

import cn.wolfcode.edu.domain.Employee;
import cn.wolfcode.edu.domain.ReceiptBill;
import cn.wolfcode.edu.query.QueryObject;

import java.util.List;

public interface ReceiptBillMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ReceiptBill record);

    ReceiptBill selectByPrimaryKey(Long id);

    List<ReceiptBill> selectAll();

    int updateByPrimaryKey(ReceiptBill record);

    /**
     * 分页条数
     * @param qo  封装的查询条件对象
     * @return
     */
    int queryForCount(QueryObject qo);

    /**
     * 分页对象集合
     * @param qo  封装的查询条件对象
     * @return
     */
    List<ReceiptBill> queryForList(QueryObject qo);

    List<ReceiptBill> selectBillsByClientId(Long id);
}