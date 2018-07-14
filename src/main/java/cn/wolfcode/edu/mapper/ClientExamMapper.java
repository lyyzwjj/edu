package cn.wolfcode.edu.mapper;

import cn.wolfcode.edu.domain.ClientExam;
import cn.wolfcode.edu.query.QueryObject;

import java.util.List;

public interface ClientExamMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ClientExam record);

    ClientExam selectByPrimaryKey(Long id);

    List<ClientExam> selectAll();

    int updateByPrimaryKey(ClientExam record);

    int queryForCount(QueryObject qo);

    List<ClientExam> queryForList(QueryObject qo);
}