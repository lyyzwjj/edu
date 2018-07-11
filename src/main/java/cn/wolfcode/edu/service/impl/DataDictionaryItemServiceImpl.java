package cn.wolfcode.edu.service.impl;

import cn.wolfcode.edu.domain.DataDictionaryItem;
import cn.wolfcode.edu.mapper.DataDictionaryItemMapper;
import cn.wolfcode.edu.service.IDataDictionaryItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by WangZhe on 2018/7/11.
 */
@Service
public class DataDictionaryItemServiceImpl implements IDataDictionaryItemService {
    @Autowired
    private DataDictionaryItemMapper dataDictionaryItemMapper;
    @Override
    public void delete(Long id) {
        dataDictionaryItemMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void save(DataDictionaryItem entity) {
        dataDictionaryItemMapper.insert(entity);
    }

    @Override
    public DataDictionaryItem get(Long id) {
        return dataDictionaryItemMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<DataDictionaryItem> list() {
        return dataDictionaryItemMapper.selectAll();
    }

    @Override
    public void update(DataDictionaryItem entity) {
        dataDictionaryItemMapper.updateByPrimaryKey(entity);
    }

    @Override
    public List<DataDictionaryItem> queryListByParent(Long id) {
        return dataDictionaryItemMapper.queryListByParent(id);
    }
}
