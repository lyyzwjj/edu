package cn.wolfcode.edu.service;

import cn.wolfcode.edu.domain.DataDictionary;
import cn.wolfcode.edu.query.PageResult;
import cn.wolfcode.edu.query.QueryObject;

import java.util.List;

/**
 * Created by WangZhe on 2018/7/11.
 */
public interface IDataDictionaryService {
    /**
     * 删除数据字典
     * @param id 待删除数据字典的id
     */
    void delete(Long id);

    /**
     * 添加数据字典
     * @param entity
     */
    void save(DataDictionary entity);

    /**
     * 查询单个数据字典
     * @param id  待查询数据字典的id
     * @return
     */
    DataDictionary get(Long id);

    /**
     * 查询所有的数据字典
     * @return
     */
    List<DataDictionary> list();

    /**
     * 更新数据字典
     * @param entity
     */
    void update(DataDictionary entity);

    /**
     * 查询到分页结果集
     * @param qo 查询参数对象
     * @return
     */
    PageResult query(QueryObject qo);
}
