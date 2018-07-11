package cn.wolfcode.edu.service.impl;

import cn.wolfcode.edu.domain.Role;
import cn.wolfcode.edu.mapper.RoleMapper;
import cn.wolfcode.edu.query.PageResult;
import cn.wolfcode.edu.query.QueryObject;
import cn.wolfcode.edu.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements IRoleService{
    @Autowired
    private RoleMapper roleMapper;

    public void save(Role entity) {
        roleMapper.insert(entity);
    }

    public void update(Role entity) {
        roleMapper.updateByPrimaryKey(entity);
    }

    public void delete(Long id) {
        roleMapper.deleteByPrimaryKey(id);
    }

    public Role get(Long id) {
        return roleMapper.selectByPrimaryKey(id);
    }

    public List<Role> list() {
        return roleMapper.selectAll();
    }

    public PageResult query(QueryObject qo) {
        int total = roleMapper.queryForCount(qo);
        if(total ==0){
            return new PageResult();
        }
        List<Role> rows = roleMapper.queryForList(qo);
        return new PageResult(total,rows);
    }

}
