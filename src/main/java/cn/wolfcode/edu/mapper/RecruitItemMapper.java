package cn.wolfcode.edu.mapper;

import cn.wolfcode.edu.domain.Recruit;
import cn.wolfcode.edu.domain.RecruitItem;
import java.util.List;

public interface RecruitItemMapper {

    int deleteByPrimaryKey(Long id);

    int insert(RecruitItem record);

    RecruitItem selectByPrimaryKey(Long id);

    List<RecruitItem> selectAll();

    int updateByPrimaryKey(RecruitItem record);

    void deleteByRecruitId(Long id);

    List<Recruit> queryByRecruitId(Long recruitId);
}