package cn.wolfcode.edu.mapper;

import cn.wolfcode.edu.domain.ClientTransferRecord;
import cn.wolfcode.edu.query.QueryObject;

import java.util.List;

public interface ClientTransferRecordMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ClientTransferRecord record);

    ClientTransferRecord selectByPrimaryKey(Long id);

    List<ClientTransferRecord> selectAll();

    int updateByPrimaryKey(ClientTransferRecord record);

    List<ClientTransferRecord> queryForList(QueryObject qo);

    int queryForCount(QueryObject qo);
}