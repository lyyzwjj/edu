package cn.wolfcode.edu.service.impl;

import cn.wolfcode.edu.domain.Systemlog;
import cn.wolfcode.edu.mapper.SystemlogMapper;
import cn.wolfcode.edu.service.ISystemlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by WangZhe on 2018/7/12.
 */
@Service
public class SystemlogServiceImpl implements ISystemlogService {
    @Autowired
    private SystemlogMapper systemlogMapper;

    @Override
    public List<Systemlog> list() {
        return systemlogMapper.selectAll();
    }

    @Override
    public void save(Systemlog entity) {
        systemlogMapper.insert(entity);
    }
}
