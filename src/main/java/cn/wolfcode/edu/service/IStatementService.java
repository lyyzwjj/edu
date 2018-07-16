package cn.wolfcode.edu.service;

import cn.wolfcode.edu.query.StatementQueryObject;

import java.util.List;
import java.util.Map;

public interface IStatementService {
    List<Map<String,Object>>selectStatement(StatementQueryObject qo);
}
