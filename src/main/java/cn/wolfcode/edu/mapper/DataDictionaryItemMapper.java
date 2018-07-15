package cn.wolfcode.edu.mapper;

import cn.wolfcode.edu.domain.DataDictionaryItem;
import java.util.List;

public interface DataDictionaryItemMapper {
    int deleteByPrimaryKey(Long id);

    int insert(DataDictionaryItem record);

    DataDictionaryItem selectByPrimaryKey(Long id);

    List<DataDictionaryItem> selectAll();

    int updateByPrimaryKey(DataDictionaryItem record);

    List<DataDictionaryItem> queryListByParent(Long parentId);

    List<DataDictionaryItem> selectByDictionarySn(String sn);
}