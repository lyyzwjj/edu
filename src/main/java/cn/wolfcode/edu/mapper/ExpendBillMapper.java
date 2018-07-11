package cn.wolfcode.edu.mapper;

import cn.wolfcode.edu.domain.ExpendBill;
import cn.wolfcode.edu.query.QueryObject;

import java.util.List;

public interface ExpendBillMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ExpendBill record);

    ExpendBill selectByPrimaryKey(Long id);

    List<ExpendBill> selectAll();

    int updateByPrimaryKey(ExpendBill record);

    /**
     * 分页总条数
     * @param qo
     * @return
     */
    int queryForCount(QueryObject qo);

    List<ExpendBill> queryForList(QueryObject qo);
}