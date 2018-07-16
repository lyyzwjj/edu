package cn.wolfcode.edu.mapper;

import cn.wolfcode.edu.domain.Sign;
import cn.wolfcode.edu.query.QueryObject;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SignMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Sign record);

    Sign selectByPrimaryKey(Long id);

    List<Sign> selectAll();

    int updateByPrimaryKey(Sign record);

    List<Sign> queryForList(@Param("qo") QueryObject qo, @Param("employeeId") Long employeeId);

    int queryForCount(@Param("qo") QueryObject qo, @Param("employeeId") Long employeeId);
}