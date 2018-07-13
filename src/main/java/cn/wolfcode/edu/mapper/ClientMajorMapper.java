package cn.wolfcode.edu.mapper;

import cn.wolfcode.edu.domain.ClientMajor;
import cn.wolfcode.edu.query.ClientMajorQueryObject;

import java.util.List;

public interface ClientMajorMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ClientMajor record);

    ClientMajor selectByPrimaryKey(Long id);

    List<ClientMajor> selectAll();

    int updateByPrimaryKey(ClientMajor record);

    int queryForCount(ClientMajorQueryObject qo);

    List<ClientMajor> queryForList(ClientMajorQueryObject qo);
}