package cn.wolfcode.edu.service;

import cn.wolfcode.edu.domain.ClientMajor;
import cn.wolfcode.edu.query.ClientMajorQueryObject;
import cn.wolfcode.edu.query.PageResult;

import java.util.List;

public interface IClientMajorService {
    /**
     * 删除潜在客户
     * @param id 待删除潜在客户的id
     */
    void delete(Long id);

    /**
     * 添加潜在客户
     * @param record
     */
    void save(ClientMajor record);

    /**
     * 查询单个潜在客户
     * @param id  待查询潜在客户的id
     * @return
     */
    ClientMajor get(Long id);

    /**
     * 查询所有的潜在客户
     * @return
     */
    List<ClientMajor> list();

    /**
     * 更新潜在客户
     * @param record
     */
    void update(ClientMajor record);

    /**
     * 查询到分页结果集
     * @param qo 查询参数对象
     * @return
     */
    PageResult query(ClientMajorQueryObject qo);

}
