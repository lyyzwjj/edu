package cn.wolfcode.edu.service;

import cn.wolfcode.edu.domain.TalentPool;
import cn.wolfcode.edu.query.PageResult;
import cn.wolfcode.edu.query.TalentPoolQueryObject;

import java.util.List;

public interface ITalentPoolService {

    void save(TalentPool talentPool);

    void update(TalentPool talentPool);

    TalentPool get(Long id);

    List<TalentPool> list();

    /**
     * 高级查询
     * @param qo
     * @return
     */
    PageResult query(TalentPoolQueryObject qo);

}
