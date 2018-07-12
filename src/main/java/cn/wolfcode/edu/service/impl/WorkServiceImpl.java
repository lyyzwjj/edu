package cn.wolfcode.edu.service.impl;

import cn.wolfcode.edu.domain.Work;
import cn.wolfcode.edu.mapper.WorkMapper;
import cn.wolfcode.edu.service.IWorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkServiceImpl implements IWorkService {
    @Autowired
    private WorkMapper workMapper;

    public void deleteByPrimaryKey(Long id) {
        workMapper.deleteByPrimaryKey(id);
    }

    public void insert(Work record) {
        workMapper.insert(record);
    }

    public Work selectByPrimaryKey(Long id) {
        return workMapper.selectByPrimaryKey(id);
    }

    public List<Work> selectAll() {
        return workMapper.selectAll();
    }

    public void updateByPrimaryKey(Work record) {
        workMapper.updateByPrimaryKey(record);
    }

    public void delete(Long staff_id) {
        workMapper.delete(staff_id);
    }

    public List<Work> queryByStaffId(Long staff_id) {
        return workMapper.queryByStaffId(staff_id);
    }
}
