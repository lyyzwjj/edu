package cn.wolfcode.edu.mapper;

import cn.wolfcode.edu.domain.StudentReceiptGather;
import java.util.List;

public interface StudentReceiptGatherMapper {
    int deleteByPrimaryKey(Long id);

    int insert(StudentReceiptGather record);

    StudentReceiptGather selectByPrimaryKey(Long id);

    List<StudentReceiptGather> selectAll();

    int updateByPrimaryKey(StudentReceiptGather record);

    StudentReceiptGather selectByClientId();
}