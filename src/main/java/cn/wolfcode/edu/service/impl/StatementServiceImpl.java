package cn.wolfcode.edu.service.impl;

import cn.wolfcode.edu.mapper.StatementMapper;
import cn.wolfcode.edu.query.StatementQueryObject;
import cn.wolfcode.edu.service.IStatementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class StatementServiceImpl implements IStatementService{
    @Autowired
    private StatementMapper mapper;

    public List<Map<String, Object>> selectStatement(StatementQueryObject qo) {

        return mapper.selectStatement(qo);
    }
}
