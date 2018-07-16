package cn.wolfcode.edu.mapper;

import cn.wolfcode.edu.query.StatementQueryObject;

import java.util.List;
import java.util.Map;

public interface StatementMapper {
    List<Map<String,Object>>selectStatement(StatementQueryObject qo);
}
