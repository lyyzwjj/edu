package cn.wolfcode.edu.service.impl;

import cn.wolfcode.edu.domain.Client;
import cn.wolfcode.edu.domain.ClientTransferRecord;
import cn.wolfcode.edu.mapper.ClientMapper;
import cn.wolfcode.edu.mapper.ClientTransferRecordMapper;
import cn.wolfcode.edu.query.PageResult;
import cn.wolfcode.edu.query.QueryObject;
import cn.wolfcode.edu.service.IClientTransferRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ClientTransferRecordServiceImpl implements IClientTransferRecordService{
    @Autowired
    private ClientTransferRecordMapper clientMapper;
    @Autowired
    private ClientMapper mapper;

    public void delete(Long id) {
        clientMapper.deleteByPrimaryKey(id);
    }

    public void save(ClientTransferRecord record) {
        //获取到当前用户的信息
        Client client = record.getClient();
        //设置转移的时间
        record.setCurrentdate(new Date());
        if(client.getInputMan()!=null){
        //当录入人不为空的时候就将其设置到前跟踪人当中
            record.setOriginalTraceMan(client.getInputMan());
        }
        if (client.getAcceptMan()!=null){
            record.setCurrentTraceMan(client.getAcceptMan());
            client.setInputMan(client.getAcceptMan());
        }
        clientMapper.insert(record);
        //同时将client表的跟踪人改成现在这个跟踪人
        //client.setInputMan(traceMan);
        mapper.changeTraceMan(client);
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
