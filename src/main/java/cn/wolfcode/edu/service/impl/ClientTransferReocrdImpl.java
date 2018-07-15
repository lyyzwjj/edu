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
public class ClientTransferReocrdImpl implements IClientTransferRecordService{
    @Autowired
    private ClientTransferRecordMapper clientMapper;
    @Autowired
    private ClientMapper mapper;

    public void delete(Long id) {
        clientMapper.deleteByPrimaryKey(id);
    }

    public void save(ClientTransferRecord record) {
        //设置当前转移时间
        record.setCurrentdate(new Date());
        System.out.println("时间====="+new Date());
        //获得客户
        Client client = record.getName();
        System.out.println("获取client"+record.getName()+"===========================");
        if (client.getInputMan()!=null){
            //设置前追踪人
            record.setOriginalTraceMan(client.getInputMan());

        }
        if (client.getAcceptMan()!=null){
            //设置现在的追踪人
            record.setCurrentTraceMan(client.getAcceptMan());
            //同时将client中的原追踪人设置为现在的追踪人
            client.setInputMan(client.getAcceptMan());
        }
        clientMapper.insert(record);
        mapper.updateByPrimaryKey(client);
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
