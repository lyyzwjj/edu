package cn.wolfcode.edu.service.impl;

import cn.wolfcode.edu.domain.TalentPool;
import cn.wolfcode.edu.mapper.TalentPoolMapper;
import cn.wolfcode.edu.query.PageResult;
import cn.wolfcode.edu.query.TalentPoolQueryObject;
import cn.wolfcode.edu.service.ITalentPoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TalentPoolServiceImpl implements ITalentPoolService{
    @Autowired
    private TalentPoolMapper talentPoolMapper;

    public void save(TalentPool talentPool) {

        talentPoolMapper.insert(talentPool);

    }

    public void update(TalentPool talentPool) {
        talentPoolMapper.updateByPrimaryKey(talentPool);

    }

    public TalentPool get(Long id) {
        return talentPoolMapper.selectByPrimaryKey(id);
    }

    public List<TalentPool> list() {
        return talentPoolMapper.selectAll();
    }

    public PageResult query(TalentPoolQueryObject qo) {
        int total = talentPoolMapper.queryForCount(qo);
        if(total ==0){
            return new PageResult();
        }
        List<TalentPool> rows = talentPoolMapper.queryForList(qo);
        return new PageResult(total,rows);
    }

}
