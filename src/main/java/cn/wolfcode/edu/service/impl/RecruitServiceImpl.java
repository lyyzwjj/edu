package cn.wolfcode.edu.service.impl;

import cn.wolfcode.edu.domain.Recruit;
import cn.wolfcode.edu.domain.RecruitItem;
import cn.wolfcode.edu.mapper.RecruitItemMapper;
import cn.wolfcode.edu.mapper.RecruitMapper;
import cn.wolfcode.edu.query.PageResult;
import cn.wolfcode.edu.query.QueryObject;
import cn.wolfcode.edu.service.IRecruitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecruitServiceImpl implements IRecruitService {
    @Autowired
    private RecruitMapper recruitMapper;
    @Autowired
    private RecruitItemMapper recruitItemMapper;

    public void deleteByPrimaryKey(Long id) {
        //删除招聘对象
        recruitMapper.deleteByPrimaryKey(id);
        //根据招聘对象删除招聘明细
        recruitItemMapper.deleteByRecruitId(id);
    }

    public void insert(Recruit record) {
        //保存招聘对象
        recruitMapper.insert(record);
        //获取所有的招聘明细
        List<RecruitItem> items = record.getItems();
        //保存明细
        for (RecruitItem item : items) {
            item.setRecruitId(record.getId());
            recruitItemMapper.insert(item);
        }
    }

    public Recruit selectByPrimaryKey(Long id) {
        return recruitMapper.selectByPrimaryKey(id);
    }

    public List<Recruit> selectAll() {
        return recruitMapper.selectAll();
    }

    public void updateByPrimaryKey(Recruit record) {
        //根据招聘对象删除招聘明细
        recruitItemMapper.deleteByRecruitId(record.getId());
        //保存明细
        //获取所有的招聘明细
        List<RecruitItem> items = record.getItems();
        //保存明细
        for (RecruitItem item : items) {
            item.setRecruitId(record.getId());
            recruitItemMapper.insert(item);
        }
        //更新
        recruitMapper.updateByPrimaryKey(record);
    }

    public PageResult query(QueryObject qo) {
        //查询总条数
        int total = recruitMapper.queryForCount(qo);
        if (total == 0) {
            return new PageResult();
        }
        //查询分页数据
        List<Recruit> rows = recruitMapper.queryForList(qo);
        for (Recruit row : rows) {
            List<RecruitItem> items = row.getItems();
            for (RecruitItem item : items) {
                System.out.println(item);
            }
        }
        return new PageResult(total, rows);
    }

    public List<Recruit> queryByRecruitId(Long recruitId) {
        return recruitItemMapper.queryByRecruitId(recruitId);
    }
}
