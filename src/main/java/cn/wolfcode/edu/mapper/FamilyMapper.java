package cn.wolfcode.edu.mapper;

import cn.wolfcode.edu.domain.Family;
import java.util.List;

public interface FamilyMapper {

    void deleteByPrimaryKey(Long id);

    void insert(Family record);

    Family selectByPrimaryKey(Long id);

    List<Family> selectAll();

    void updateByPrimaryKey(Family record);

    List<Family> queryByStaffId(Long staff_id);

    void delete(Long staff_id);
}