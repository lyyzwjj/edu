package cn.wolfcode.edu.service.impl;

import cn.wolfcode.edu.domain.ClientMajor;
import cn.wolfcode.edu.mapper.ClientMajorMapper;
import cn.wolfcode.edu.query.ClientMajorQueryObject;
import cn.wolfcode.edu.query.PageResult;
import cn.wolfcode.edu.service.IClientMajorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientMajorServiceImpl implements IClientMajorService{
    @Autowired
    private ClientMajorMapper clientMapper;

    public void delete(Long id) {
        clientMapper.deleteByPrimaryKey(id);
    }

    public void save(ClientMajor record) {
        clientMapper.insert(record);
    }

    public ClientMajor get(Long id) {
        return clientMapper.selectByPrimaryKey(id);
    }

    public List<ClientMajor> list() {
        return clientMapper.selectAll();
    }

    public void update(ClientMajor record) {
        clientMapper.updateByPrimaryKey(record);
    }

    public PageResult query(ClientMajorQueryObject qo) {
        //查询总条数
        int total = clientMapper.queryForCount(qo);
        if(total==0){
            return new PageResult();
        }
        //查询分页数据
        List<ClientMajor> rows = clientMapper.queryForList(qo);
        return new PageResult(total, rows);
    }

}
