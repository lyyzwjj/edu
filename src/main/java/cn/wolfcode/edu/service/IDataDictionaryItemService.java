package cn.wolfcode.edu.service;

import cn.wolfcode.edu.domain.DataDictionaryItem;

import java.util.List;

/**
 * Created by WangZhe on 2018/7/11.
 */
public interface IDataDictionaryItemService {
    /**
     * 删除数据字典明细
     * @param id 待删除数据字典明细的id
     */
    void delete(Long id);

    /**
     * 添加数据字典明细
     * @param entity
     */
    void save(DataDictionaryItem entity);

    /**
     * 查询单个数据字典明细
     * @param id  待查询数据字典明细的id
     * @return
     */
    DataDictionaryItem get(Long id);

    /**
     * 查询所有的数据字典明细
     * @return
     */
    List<DataDictionaryItem> list();

    /**
     * 更新数据字典明细
     * @param entity
     */
    void update(DataDictionaryItem entity);

    /**
     * 根据字典编号查询对应的字典明细列表
     * @param id 字典编号
     * @return 返回对应的字典明细列表
     */
    List<DataDictionaryItem> queryListByParent(Long parentId);
}
