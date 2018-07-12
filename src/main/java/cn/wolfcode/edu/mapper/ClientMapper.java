package cn.wolfcode.edu.mapper;

import cn.wolfcode.edu.domain.Client;
import cn.wolfcode.edu.query.ClientQueryObject;
import cn.wolfcode.edu.query.QueryObject;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ClientMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Client record);

    Client selectByPrimaryKey(Long id);

    List<Client> selectAll();

    int updateByPrimaryKey(Client record);

    int queryForCount(ClientQueryObject qo);

    List<Client> queryForList(ClientQueryObject qo);

    void changeState(@Param("id") Long id, @Param("stateId") int stateId);

    List<Client> queryClients(QueryObject qo);

    /**
     * 资源池客户列表
     * @param qo
     * @return
     */
    List<Client> queryPoolClientList(QueryObject qo);

    /**
     * 资源池客户的条数
     * @param qo
     * @return
     */
    int queryForPoolClientCount(QueryObject qo);

    void insertPoolClient(Client client);
}