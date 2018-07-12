package cn.wolfcode.edu.mapper;

import cn.wolfcode.edu.domain.Work;
import java.util.List;

public interface WorkMapper {

    void deleteByPrimaryKey(Long id);

    void insert(Work record);

    Work selectByPrimaryKey(Long id);

    List<Work> selectAll();

    void updateByPrimaryKey(Work record);

    List<Work> queryByStaffId(Long staff_id);

    void delete(Long staff_id);
}