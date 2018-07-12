package cn.wolfcode.edu.service.impl;

import cn.wolfcode.edu.domain.ClientTrace;
import cn.wolfcode.edu.mapper.ClientTraceMapper;
import cn.wolfcode.edu.query.PageResult;
import cn.wolfcode.edu.query.QueryObject;
import cn.wolfcode.edu.service.IClientTraceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientTraceServiceImpl implements IClientTraceService{
    @Autowired
    private ClientTraceMapper clientMapper;

    public void delete(Long id) {
        clientMapper.deleteByPrimaryKey(id);
    }

    public void save(ClientTrace record) {
        clientMapper.insert(record);
    }

    public ClientTrace get(Long id) {
        return clientMapper.selectByPrimaryKey(id);
    }

    public List<ClientTrace> list() {
        return clientMapper.selectAll();
    }

    public void update(ClientTrace record) {
        clientMapper.updateByPrimaryKey(record);
    }

    public PageResult query(QueryObject qo) {
        //查询总条数
        int total = clientMapper.queryForCount(qo);
        if(total==0){
            return new PageResult();
        }
        //查询分页数据
        List<ClientTrace> rows = clientMapper.queryForList(qo);
        return new PageResult(total, rows);
    }

}
