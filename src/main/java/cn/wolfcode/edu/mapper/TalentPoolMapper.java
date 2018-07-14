package cn.wolfcode.edu.mapper;

import cn.wolfcode.edu.domain.TalentPool;
import cn.wolfcode.edu.query.TalentPoolQueryObject;

import java.util.List;

public interface TalentPoolMapper {

    int insert(TalentPool record);

    TalentPool selectByPrimaryKey(Long id);

    List<TalentPool> selectAll();

    int updateByPrimaryKey(TalentPool record);

    int queryForCount(TalentPoolQueryObject qo);

    List<TalentPool> queryForList(TalentPoolQueryObject qo);
}