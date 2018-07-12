package cn.wolfcode.edu.mapper;

import cn.wolfcode.edu.domain.ClientTrace;
import cn.wolfcode.edu.query.QueryObject;

import java.util.List;

public interface ClientTraceMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ClientTrace record);

    ClientTrace selectByPrimaryKey(Long id);

    List<ClientTrace> selectAll();

    int updateByPrimaryKey(ClientTrace record);

    int queryForCount(QueryObject qo);

    List<ClientTrace> queryForList(QueryObject qo);
}