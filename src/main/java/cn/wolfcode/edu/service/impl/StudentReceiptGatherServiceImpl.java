package cn.wolfcode.edu.service.impl;

import cn.wolfcode.edu.domain.StudentReceiptGather;
import cn.wolfcode.edu.mapper.StudentReceiptGatherMapper;
import cn.wolfcode.edu.query.PageResult;
import cn.wolfcode.edu.query.QueryObject;
import cn.wolfcode.edu.service.IStudentReceiptGatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Created by WangZhe on 2018/7/10.
 */
@Service
public class StudentReceiptGatherServiceImpl implements IStudentReceiptGatherService{
    @Autowired
    private StudentReceiptGatherMapper studentReceiptGatherMapper;

    @Override
    public int delete(Long id) {
        return studentReceiptGatherMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int save(StudentReceiptGather record) {
       

        return studentReceiptGatherMapper.insert(record);
    }

    @Override
    public StudentReceiptGather get(Long id) {
        return studentReceiptGatherMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<StudentReceiptGather> list() {
        return studentReceiptGatherMapper.selectAll();
    }

    @Override
    public int update(StudentReceiptGather record) {
        return studentReceiptGatherMapper.updateByPrimaryKey(record);
    }
}
