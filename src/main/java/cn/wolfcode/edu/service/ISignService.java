package cn.wolfcode.edu.service;

import cn.wolfcode.edu.domain.Sign;
import cn.wolfcode.edu.query.PageResult;
import cn.wolfcode.edu.query.QueryObject;

import java.util.List;

/**
 * Created by WangZhe on 2018/7/16.
 */

public interface ISignService {
    void deleteByPrimaryKey(Long id);

    void insert(Sign record);

    Sign selectByPrimaryKey(Long id);

    List<Sign> selectAll();

    void updateByPrimaryKey(Sign record);

    PageResult query(QueryObject qo);

    void signIn();

    void signOut();

}
