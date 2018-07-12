package cn.wolfcode.edu.service;

import cn.wolfcode.edu.domain.Work;

import java.util.List;

public interface IWorkService {

    /**
     * 删除
     * @param id
     */
    void deleteByPrimaryKey(Long id);

    /**
     * 添加
     * @param record
     */
    void insert(Work record);

    /**
     * 查询单个
     * @param id
     * @return
     */
    Work selectByPrimaryKey(Long id);

    /**
     * 查询所有
     * @return
     */
    List<Work> selectAll();

    /**
     * 更新
     * @param record
     */
    void updateByPrimaryKey(Work record);

    /**
     * 根据员工id删除明细
     * @param staff_id
     */
    void delete(Long staff_id);

    /**
     * 根据员工id查询明细
     * @param staff_id
     * @return
     */
    List<Work> queryByStaffId(Long staff_id);
}
