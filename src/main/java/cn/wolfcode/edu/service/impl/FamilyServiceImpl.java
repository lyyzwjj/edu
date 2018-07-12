package cn.wolfcode.edu.service.impl;

import cn.wolfcode.edu.domain.Family;
import cn.wolfcode.edu.mapper.FamilyMapper;
import cn.wolfcode.edu.service.IFamilyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FamilyServiceImpl implements IFamilyService {

    @Autowired
    private FamilyMapper familyMapper;

    public void deleteByPrimaryKey(Long id) {
        familyMapper.deleteByPrimaryKey(id);
    }

    public void insert(Family record) {
        familyMapper.insert(record);
    }

    public Family selectByPrimaryKey(Long id) {
        return familyMapper.selectByPrimaryKey(id);
    }

    public List<Family> selectAll() {
        return familyMapper.selectAll();
    }

    public void updateByPrimaryKey(Family record) {
        familyMapper.updateByPrimaryKey(record);
    }

    public List<Family> queryByStaffId(Long staff_id) {
        return familyMapper.queryByStaffId(staff_id);
    }

    public void delete(Long staff_id) {
        familyMapper.delete(staff_id);
    }
}
