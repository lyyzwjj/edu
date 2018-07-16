package cn.wolfcode.edu.service.impl;

import cn.wolfcode.edu.domain.Employee;
import cn.wolfcode.edu.domain.Recruit;
import cn.wolfcode.edu.domain.RecruitItem;
import cn.wolfcode.edu.mapper.DepartmentMapper;
import cn.wolfcode.edu.mapper.RecruitItemMapper;
import cn.wolfcode.edu.mapper.RecruitMapper;
import cn.wolfcode.edu.query.PageResult;
import cn.wolfcode.edu.query.QueryObject;
import cn.wolfcode.edu.service.IRecruitService;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class RecruitServiceImpl implements IRecruitService {
    @Autowired
    private RecruitMapper recruitMapper;
    @Autowired
    private RecruitItemMapper recruitItemMapper;
    @Autowired
    private DepartmentMapper departmentMapper;

    public void deleteByPrimaryKey(Long id) {
        //删除招聘对象
        recruitMapper.deleteByPrimaryKey(id);
        //根据招聘对象删除招聘明细
        recruitItemMapper.deleteByRecruitId(id);
    }

    public void insert(Recruit record) {
        //先保存数据录入人信息
        Employee employee = (Employee) SecurityUtils.getSubject().getPrincipals().getPrimaryPrincipal();
        record.setInputUser(employee);
        record.setDept(employee.getDept());
        //保存招聘对象
        recruitMapper.insert(record);
        //获取所有的招聘明细
        List<RecruitItem> items = record.getItems();
        //保存明细
        for (RecruitItem item : items) {
            item.setRecruitId(record.getId());
            recruitItemMapper.insert(item);
        }
    }

    public Recruit selectByPrimaryKey(Long id) {
        return recruitMapper.selectByPrimaryKey(id);
    }

    public List<Recruit> selectAll() {
        return recruitMapper.selectAll();
    }

    public void updateByPrimaryKey(Recruit record) {
        //根据招聘对象删除招聘明细
        recruitItemMapper.deleteByRecruitId(record.getId());
        //保存明细
        //获取所有的招聘明细
        List<RecruitItem> items = record.getItems();
        //保存明细
        for (RecruitItem item : items) {
            item.setRecruitId(record.getId());
            recruitItemMapper.insert(item);
        }
        //更新
        recruitMapper.updateByPrimaryKey(record);
    }

    public PageResult query(QueryObject qo) {
        //查询总条数
        int total = recruitMapper.queryForCount(qo);
        if (total == 0) {
            return new PageResult();
        }
        //查询分页数据
        List<Recruit> rows = recruitMapper.queryForList(qo);
        for (Recruit row : rows) {
            List<RecruitItem> items = row.getItems();
            for (RecruitItem item : items) {
                System.out.println(item);
            }
        }
        return new PageResult(total, rows);
    }

    public List<Recruit> queryByRecruitId(Long recruitId) {
        return recruitItemMapper.queryByRecruitId(recruitId);
    }

    /**
     * 根据id审核明细
     *
     * @param id
     */
    public void auditRecruit(Long id) {
        //1.根据id查询到招聘对象
        Recruit recruit = recruitMapper.selectByPrimaryKey(id);
        //2.如果对象为未审核状态才会执行以下的操作
        if (recruit.getExamineState() == 0) {
            //3.设置审核时间
            recruit.setAuditTime(new Date());
            //4.设置审核人信息
            Employee employee = (Employee) SecurityUtils.getSubject().getPrincipals().getPrimaryPrincipal();
            recruit.setAuditor(employee);
            //5.改变状态值
            recruit.setExamineState(1);
            //6.审核
            recruitMapper.auditRecruit(recruit);
        }
    }
}
