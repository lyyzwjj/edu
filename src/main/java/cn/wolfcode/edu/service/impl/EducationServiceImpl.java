package cn.wolfcode.edu.service.impl;

import cn.wolfcode.edu.domain.Education;
import cn.wolfcode.edu.mapper.EducationMapper;
import cn.wolfcode.edu.service.IEducationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EducationServiceImpl implements IEducationService {

    @Autowired
    private EducationMapper educationMapper;

    public void deleteByPrimaryKey(Long id) {
        educationMapper.deleteByPrimaryKey(id);
    }

    public void insert(Education record) {
        educationMapper.insert(record);
    }

    public Education selectByPrimaryKey(Long id) {
        return educationMapper.selectByPrimaryKey(id);
    }

    public List<Education> selectAll() {
        return educationMapper.selectAll();
    }

    public void updateByPrimaryKey(Education record) {
        educationMapper.updateByPrimaryKey(record);
    }

    public void delete(Long staff_id) {
        educationMapper.delete(staff_id);
    }

    public List<Education> queryByStaffId(Long staff_id) {
        return educationMapper.queryByStaffId(staff_id);
    }
}
