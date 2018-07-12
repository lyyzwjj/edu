package cn.wolfcode.edu.service;

import cn.wolfcode.edu.domain.Client;
import cn.wolfcode.edu.query.ClientQueryObject;
import cn.wolfcode.edu.query.PageResult;

import java.util.List;

public interface IClientService {
    /**
     * 删除潜在客户
     * @param id 待删除潜在客户的id
     */
    void delete(Long id);

    /**
     * 添加潜在客户
     * @param record
     */
    void save(Client record);

    /**
     * 查询单个潜在客户
     * @param id  待查询潜在客户的id
     * @return
     */
    Client get(Long id);

    /**
     * 查询所有的潜在客户
     * @return
     */
    List<Client> list();

    /**
     * 更新潜在客户
     * @param record
     */
    void update(Client record);

    /**
     * 查询到分页结果集
     * @param qo 查询参数对象
     * @return
     */
    PageResult query(ClientQueryObject qo);

    /**
     * 根据id将潜在学员转正
     * @return
     */
    void changeState(Long id,Long stateId);

    //收款列表的所有正式学员
    List<Client> queryClients();

    /**
     * 资源池中的客户列表
     * @return
     */
    List<Client> queryPoolClient();
}
