package cn.wolfcode.edu.service;

import cn.wolfcode.edu.domain.Systemlog;

import java.util.List;

/**
 * Created by WangZhe on 2018/7/12.
 */
public interface ISystemlogService {
    /**
     * 查询所有的日志
     * @return
     */
    List<Systemlog> list();
    /**
     * 添加日志
     * @param record
     */
    void save(Systemlog record);
}
