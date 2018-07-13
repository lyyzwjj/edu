package cn.wolfcode.edu.service.impl;

import cn.wolfcode.edu.domain.ClientSchoolLinkman;
import cn.wolfcode.edu.mapper.ClientSchoolLinkmanMapper;
import cn.wolfcode.edu.query.ClientQueryObject;
import cn.wolfcode.edu.query.PageResult;
import cn.wolfcode.edu.service.IClientSchoolLinkmanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientSchoolLinkmanServiceImpl implements IClientSchoolLinkmanService{
    @Autowired
    private ClientSchoolLinkmanMapper clientMapper;

    public void delete(Long id) {
        clientMapper.deleteByPrimaryKey(id);
    }

    public void save(ClientSchoolLinkman record) {
        clientMapper.insert(record);
    }

    public ClientSchoolLinkman get(Long id) {
        return clientMapper.selectByPrimaryKey(id);
    }

    public List<ClientSchoolLinkman> list() {
        return clientMapper.selectAll();
    }

    public void update(ClientSchoolLinkman record) {
        clientMapper.updateByPrimaryKey(record);
    }

    public PageResult query(ClientQueryObject qo) {
        //查询总条数
        int total = clientMapper.queryForCount(qo);
        if(total==0){
            return new PageResult();
        }
        //查询分页数据
        List<ClientSchoolLinkman> rows = clientMapper.queryForList(qo);
        return new PageResult(total, rows);
    }

}
