package cn.wolfcode.edu.service;

import cn.wolfcode.edu.domain.Campus;
import cn.wolfcode.edu.query.PageResult;
import cn.wolfcode.edu.query.QueryObject;

import java.util.List;

public interface ICampusService {

    Campus get(Long id);

    List<Campus> list();

}
