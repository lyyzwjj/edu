package cn.wolfcode.edu.service.impl;

import cn.wolfcode.edu.domain.Campus;
import cn.wolfcode.edu.mapper.CampusMapper;
import cn.wolfcode.edu.query.PageResult;
import cn.wolfcode.edu.service.ICampusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CampusServiceImpl implements ICampusService{
    @Autowired
    private CampusMapper campusMapper;

    public Campus get(Long id) {
        return campusMapper.selectByPrimaryKey(id);
    }

    public List<Campus> list() {
        return campusMapper.selectAll();
    }

}
