package cn.wolfcode.edu.mapper;

import cn.wolfcode.edu.domain.Job;
import cn.wolfcode.edu.query.QueryObject;

import java.util.List;

public interface JobMapper {

    /**
     * 删除
     * @param id
     */
    void deleteByPrimaryKey(Long id);

    /**
     * 添加
     * @param record
     */
    void insert(Job record);

    /**
     * 查询单个对象
     * @param id
     * @return
     */
    Job selectByPrimaryKey(Long id);

    /**
     * 查询所有
     * @return
     */
    List<Job> selectAll();

    /**
     * 更新
     * @param record
     */
    void updateByPrimaryKey(Job record);

    /**
     * 查询分页结果集
     * @param qo 封装的查询对象
     * @return
     */
    List<Job> queryForList(QueryObject qo);

    /**
     * 查询分页条数
     * @param qo 封装的查询对象
     * @return
     */
    int queryForCount(QueryObject qo);
}