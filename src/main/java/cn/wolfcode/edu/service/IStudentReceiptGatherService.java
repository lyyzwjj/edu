package cn.wolfcode.edu.service;

import cn.wolfcode.edu.domain.StudentReceiptGather;
import cn.wolfcode.edu.query.PageResult;
import cn.wolfcode.edu.query.QueryObject;

import java.util.List;

/**
 * Created by WangZhe on 2018/7/10.
 */
public interface IStudentReceiptGatherService {

    int delete(Long id);

    int save(StudentReceiptGather record);

    StudentReceiptGather get(Long id);

    List<StudentReceiptGather> list();

    int update(StudentReceiptGather record);
}
