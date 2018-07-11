package cn.wolfcode.edu.service.impl;

import cn.wolfcode.edu.domain.DataDictionary;
import cn.wolfcode.edu.domain.Employee;
import cn.wolfcode.edu.mapper.DataDictionaryMapper;
import cn.wolfcode.edu.query.PageResult;
import cn.wolfcode.edu.query.QueryObject;
import cn.wolfcode.edu.service.IDataDictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by WangZhe on 2018/7/11.
 */
@Service
public class DataDictionaryServiceImpl implements IDataDictionaryService{
    @Autowired
    private DataDictionaryMapper dataDictionaryMapper;


    @Override
    public void delete(Long id) {
        dataDictionaryMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void save(DataDictionary entity) {
        dataDictionaryMapper.insert(entity);
    }

    @Override
    public DataDictionary get(Long id) {
        return dataDictionaryMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<DataDictionary> list() {
        return dataDictionaryMapper.selectAll();
    }

    @Override
    public void update(DataDictionary entity) {
        dataDictionaryMapper.updateByPrimaryKey(entity);
    }

    @Override
    public PageResult query(QueryObject qo) {
        //查询总条数
        int total = dataDictionaryMapper.queryForCount(qo);
        //查询分页数据
        List<DataDictionary> rows = dataDictionaryMapper.queryForList(qo);
        return new PageResult(total, rows);
    }
}
