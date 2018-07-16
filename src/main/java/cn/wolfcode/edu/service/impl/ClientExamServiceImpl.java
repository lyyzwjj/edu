package cn.wolfcode.edu.service.impl;

import cn.wolfcode.edu.domain.ClientExam;
import cn.wolfcode.edu.domain.Employee;
import cn.wolfcode.edu.mapper.ClientExamMapper;
import cn.wolfcode.edu.query.PageResult;
import cn.wolfcode.edu.query.QueryObject;
import cn.wolfcode.edu.service.IClientExamService;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientExamServiceImpl implements IClientExamService{
    @Autowired
    private ClientExamMapper clientMapper;

    public void delete(Long id) {
        clientMapper.deleteByPrimaryKey(id);
    }

    public void save(ClientExam record) {
        Employee currentUser = (Employee)SecurityUtils.getSubject().getPrincipals().getPrimaryPrincipal();
        if (currentUser!=null){

            record.setInputMan(currentUser);
        }
        clientMapper.insert(record);
    }

    public ClientExam get(Long id) {
        return clientMapper.selectByPrimaryKey(id);
    }

    public List<ClientExam> list() {
        return clientMapper.selectAll();
    }

    public void update(ClientExam record) {
        clientMapper.updateByPrimaryKey(record);
    }

    public PageResult query(QueryObject qo) {
        //查询总条数
        int total = clientMapper.queryForCount(qo);
        if(total==0){
            return new PageResult();
        }
        //查询分页数据
        List<ClientExam> rows = clientMapper.queryForList(qo);
        return new PageResult(total, rows);
    }

    public void changeState(Long id) {
        clientMapper.changeState(id);
    }

}
