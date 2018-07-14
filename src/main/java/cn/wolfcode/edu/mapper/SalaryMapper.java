package cn.wolfcode.edu.mapper;

import cn.wolfcode.edu.domain.Salary;
import cn.wolfcode.edu.query.QueryObject;

import java.util.List;

public interface SalaryMapper {

    /**
     * 删除
     * @param id
     */
    void deleteByPrimaryKey(Long id);

    /**
     * 添加
     * @param record
     */
    void insert(Salary record);

    /**
     * 查询单个
     * @param id
     * @return
     */
    Salary selectByPrimaryKey(Long id);

    /**
     * 查询所有
     * @return
     */
    List<Salary> selectAll();

    /**
     * 更新
     * @param record
     */
    void updateByPrimaryKey(Salary record);

    /**
     * 分页结果集
     * @param qo
     * @return
     */
    List<Salary> queryForList(QueryObject qo);

    /**
     * 分页条数
     * @param qo
     * @return
     */
    int queryForCount(QueryObject qo);
}