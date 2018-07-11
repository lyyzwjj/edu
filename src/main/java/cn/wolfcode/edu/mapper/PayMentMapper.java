package cn.wolfcode.edu.mapper;

import cn.wolfcode.edu.domain.PayMent;
import java.util.List;

public interface PayMentMapper {
    int deleteByPrimaryKey(Long id);

    int insert(PayMent record);

    PayMent selectByPrimaryKey(Long id);

    List<PayMent> selectAll();

    int updateByPrimaryKey(PayMent record);
}