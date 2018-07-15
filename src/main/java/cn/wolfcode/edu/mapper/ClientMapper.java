package cn.wolfcode.edu.mapper;

import cn.wolfcode.edu.domain.Client;
import cn.wolfcode.edu.query.ClientQueryObject;
import cn.wolfcode.edu.query.QueryObject;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface ClientMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Client record);

    Client selectByPrimaryKey(Long id);

    List<Client> selectAll();

    int updateByPrimaryKey(Client record);

    int queryForCount(ClientQueryObject qo);

    List<Client> queryForList(ClientQueryObject qo);

    void changeState(@Param("id") Long id, @Param("stateId") int stateId,@Param("transferDate") Date transferDate);

    List<Client> queryClients(QueryObject qo);

    /**
     * 资源池客户列表
     * @param qo
     * @return
     */
    List<Client> queryPoolClientList(ClientQueryObject qo);

    /**
     * 资源池客户的条数
     * @param qo
     * @return
     */
    int queryForPoolClientCount(ClientQueryObject qo);

    List<Client> listStudents();

    void updateByStudent(Client client);

    void changeTrend(Long id, Long i);

    void changeTraceMan(Client client);
}