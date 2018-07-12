package cn.wolfcode.edu.service;

import cn.wolfcode.edu.domain.Education;

import java.util.List;

public interface IEducationService {

    /**
     * 删除
     * @param id
     */
    void deleteByPrimaryKey(Long id);

    /**
     * 添加
     * @param record
     */
    void insert(Education record);

    /**
     * 查询单个
     * @param id
     * @return
     */
    Education selectByPrimaryKey(Long id);

    /**
     * 查询所有
     * @return
     */
    List<Education> selectAll();

    /**
     * 更新
     * @param record
     */
    void updateByPrimaryKey(Education record);

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
    List<Education> queryByStaffId(Long staff_id);
}
