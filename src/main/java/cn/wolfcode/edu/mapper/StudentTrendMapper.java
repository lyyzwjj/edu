package cn.wolfcode.edu.mapper;

import cn.wolfcode.edu.domain.Client;
import cn.wolfcode.edu.domain.StudentTrend;
import cn.wolfcode.edu.query.ClientQueryObject;
import cn.wolfcode.edu.query.QueryObject;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentTrendMapper {
    int deleteByPrimaryKey(Long id);

    int insert(StudentTrend record);

    StudentTrend selectByPrimaryKey(Long id);

    List<StudentTrend> selectAll();

    int updateByPrimaryKey(StudentTrend record);

    void changeState(@Param("id") Long id, @Param("stateId") int stateId);

    int queryForCount(QueryObject qo);

    List<StudentTrend> queryForList(QueryObject qo);
}