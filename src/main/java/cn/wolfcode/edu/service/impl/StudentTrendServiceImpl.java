package cn.wolfcode.edu.service.impl;

import cn.wolfcode.edu.domain.StudentTrend;
import cn.wolfcode.edu.mapper.StudentTrendMapper;
import cn.wolfcode.edu.query.QueryObject;
import cn.wolfcode.edu.query.PageResult;
import cn.wolfcode.edu.service.IStudentTrendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class StudentTrendServiceImpl implements IStudentTrendService{
    @Autowired
    private StudentTrendMapper studentTrendMapper;

    public void save(StudentTrend entity) {
        entity.setExchangetime(new Date());
        studentTrendMapper.insert(entity);
    }

    public void update(StudentTrend entity) {
        studentTrendMapper.updateByPrimaryKey(entity);
    }

    public void delete(Long id) {
        studentTrendMapper.deleteByPrimaryKey(id);
    }

    public StudentTrend get(Long id) {
        return studentTrendMapper.selectByPrimaryKey(id);
    }

    public List<StudentTrend> list() {
        return studentTrendMapper.selectAll();
    }

    /**
     * 根据传入的id和状态值 修改状态
     * @param id
     * @param stateId
     */
    public void changeState(Long id,int stateId) {
        studentTrendMapper.changeState(id,stateId);
    }

    public PageResult query(QueryObject qo) {
        int total = studentTrendMapper.queryForCount(qo);
        if(total ==0){
            return new PageResult();
        }
        List<StudentTrend> rows = studentTrendMapper.queryForList(qo);
        return new PageResult(total,rows);
    }

}
