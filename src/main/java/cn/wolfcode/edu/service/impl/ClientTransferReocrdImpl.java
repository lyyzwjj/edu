package cn.wolfcode.edu.service.impl;

import cn.wolfcode.edu.domain.ClientTransferRecord;
import cn.wolfcode.edu.mapper.ClientTransferRecordMapper;
import cn.wolfcode.edu.query.PageResult;
import cn.wolfcode.edu.query.QueryObject;
import cn.wolfcode.edu.service.IClientTransferRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientTransferReocrdImpl implements IClientTransferRecordService{
    @Autowired
    private ClientTransferRecordMapper clientMapper;

    public void delete(Long id) {
        clientMapper.deleteByPrimaryKey(id);
    }

    public void save(ClientTransferRecord record) {
        clientMapper.insert(record);
    }

    public ClientTransferRecord get(Long id) {
        return clientMapper.selectByPrimaryKey(id);
    }

    public List<ClientTransferRecord> list() {
        return clientMapper.selectAll();
    }

    public void update(ClientTransferRecord record) {
        clientMapper.updateByPrimaryKey(record);
    }

    public PageResult query(QueryObject qo) {
        //查询总条数
        int total = clientMapper.queryForCount(qo);
        if(total==0){
            return new PageResult();
        }
        //查询分页数据
        List<ClientTransferRecord> rows = clientMapper.queryForList(qo);
        return new PageResult(total, rows);
    }

}
