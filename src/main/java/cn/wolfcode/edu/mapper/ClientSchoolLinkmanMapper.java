package cn.wolfcode.edu.mapper;

import cn.wolfcode.edu.domain.ClientSchoolLinkman;
import cn.wolfcode.edu.query.ClientQueryObject;

import java.util.List;

public interface ClientSchoolLinkmanMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ClientSchoolLinkman record);

    ClientSchoolLinkman selectByPrimaryKey(Long id);

    List<ClientSchoolLinkman> selectAll();

    int updateByPrimaryKey(ClientSchoolLinkman record);

    int queryForCount(ClientQueryObject qo);

    List<ClientSchoolLinkman> queryForList(ClientQueryObject qo);
}