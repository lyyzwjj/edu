package cn.wolfcode.edu.mapper;

import cn.wolfcode.edu.domain.Client;
import cn.wolfcode.edu.query.ClientQueryObject;
import cn.wolfcode.edu.query.QueryObject;

import java.util.List;

public interface ClientMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Client record);

    Client selectByPrimaryKey(Long id);

    List<Client> selectAll();

    int updateByPrimaryKey(Client record);

    int queryForCount(ClientQueryObject qo);

    List<Client> queryForList(ClientQueryObject qo);

    List<Client> queryClients(QueryObject qo);
}