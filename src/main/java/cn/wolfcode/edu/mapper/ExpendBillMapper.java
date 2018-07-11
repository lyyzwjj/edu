package cn.wolfcode.edu.mapper;

import cn.wolfcode.edu.domain.ExpendBill;
import java.util.List;

public interface ExpendBillMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ExpendBill record);

    ExpendBill selectByPrimaryKey(Long id);

    List<ExpendBill> selectAll();

    int updateByPrimaryKey(ExpendBill record);
}