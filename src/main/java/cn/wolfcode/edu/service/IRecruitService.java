package cn.wolfcode.edu.service;

import cn.wolfcode.edu.domain.Recruit;
import cn.wolfcode.edu.query.PageResult;
import cn.wolfcode.edu.query.QueryObject;

import java.util.List;

public interface IRecruitService {

    /**
     * 删除
     * @param id
     */
    void deleteByPrimaryKey(Long id);

    /**
     * 添加
     * @param record
     */
    void insert(Recruit record);

    /**
     * 查询单个
     * @param id
     * @return
     */
    Recruit selectByPrimaryKey(Long id);

    /**
     * 查询多个
     * @return
     */
    List<Recruit> selectAll();

    /**
     * 更新
     * @param record
     */
    void updateByPrimaryKey(Recruit record);

    /**
     * 分页结果集
     * @param qo
     * @return
     */
    PageResult query(QueryObject qo);

    /**
     * 根据id查询所有的明细
     * @param id
     * @return
     */

    List<Recruit> queryByRecruitId(Long recruitId);

    /**
     * 审核招聘明细
     * @param id
     */
    void auditRecruit(Long id);
}
