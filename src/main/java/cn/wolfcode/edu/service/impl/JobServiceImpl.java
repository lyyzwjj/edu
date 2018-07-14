package cn.wolfcode.edu.service.impl;

import cn.wolfcode.edu.domain.Job;
import cn.wolfcode.edu.mapper.JobMapper;
import cn.wolfcode.edu.query.PageResult;
import cn.wolfcode.edu.query.QueryObject;
import cn.wolfcode.edu.service.IJobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobServiceImpl implements IJobService {
    @Autowired
    private JobMapper jobMapper;

    public void deleteByPrimaryKey(Long id) {
        jobMapper.deleteByPrimaryKey(id);
    }

    public void insert(Job record) {
        jobMapper.insert(record);
    }

    public Job selectByPrimaryKey(Long id) {
        return jobMapper.selectByPrimaryKey(id);
    }

    public List<Job> selectAll() {
        return jobMapper.selectAll();
    }

    public void updateByPrimaryKey(Job record) {
        jobMapper.updateByPrimaryKey(record);
    }

    public PageResult query(QueryObject qo) {
        //查询总条数
        int total = jobMapper.queryForCount(qo);
        if (total == 0) {
            return new PageResult();
        }
        //查询分页数据
        List<Job> rows = jobMapper.queryForList(qo);
        return new PageResult(total, rows);
    }
}
