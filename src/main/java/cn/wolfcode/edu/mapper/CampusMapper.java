package cn.wolfcode.edu.mapper;

import cn.wolfcode.edu.domain.Campus;
import java.util.List;

public interface CampusMapper {

    Campus selectByPrimaryKey(Long id);

    List<Campus> selectAll();

}