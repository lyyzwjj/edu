package cn.wolfcode.edu.service;

import cn.wolfcode.edu.domain.ClientExam;
import cn.wolfcode.edu.query.PageResult;
import cn.wolfcode.edu.query.QueryObject;

import java.util.List;

public interface IClientExamService {
    /**
     * 删除潜在客户
     * @param id 待删除潜在客户的id
     */
    void delete(Long id);

    /**
     * 添加潜在客户
     * @param record
     */
    void save(ClientExam record);

    /**
     * 查询单个潜在客户
     * @param id  待查询潜在客户的id
     * @return
     */
    ClientExam get(Long id);

    /**
     * 查询所有的潜在客户
     * @return
     */
    List<ClientExam> list();

    /**
     * 更新潜在客户
     * @param record
     */
    void update(ClientExam record);

    /**
     * 查询到分页结果集
     * @param qo 查询参数对象
     * @return
     */
    PageResult query(QueryObject qo);

    /**
     * 审核考试是否通过
     * @param id
     */
    void changeState(Long id);

}
