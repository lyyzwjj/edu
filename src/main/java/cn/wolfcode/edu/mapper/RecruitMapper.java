package cn.wolfcode.edu.mapper;

import cn.wolfcode.edu.domain.Recruit;
import cn.wolfcode.edu.query.QueryObject;

import java.util.List;

public interface RecruitMapper {

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
     * 分页数据
     * @param qo
     * @return
     */
    List<Recruit> queryForList(QueryObject qo);


    /**
     * 分页条数
     * @param qo
     * @return
     */
    int queryForCount(QueryObject qo);
}