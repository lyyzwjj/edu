package cn.wolfcode.edu.service.impl;

import cn.wolfcode.edu.domain.Employee;
import cn.wolfcode.edu.domain.Sign;
import cn.wolfcode.edu.mapper.SignMapper;
import cn.wolfcode.edu.query.PageResult;
import cn.wolfcode.edu.query.QueryObject;
import cn.wolfcode.edu.service.ISignService;
import cn.wolfcode.edu.util.SignTimeUtil;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class SignServiceImpl implements ISignService {
    @Autowired
    private SignMapper signMapper;

    public void deleteByPrimaryKey(Long id) {
        signMapper.deleteByPrimaryKey(id);
    }

    public void insert(Sign record) {
        signMapper.insert(record);
    }

    public Sign selectByPrimaryKey(Long id) {
        return signMapper.selectByPrimaryKey(id);
    }

    public List<Sign> selectAll() {
        return signMapper.selectAll();
    }

    public void updateByPrimaryKey(Sign record) {
        signMapper.updateByPrimaryKey(record);
    }

    public PageResult query(QueryObject qo) {
        Employee currentUser = (Employee) SecurityUtils.getSubject().getPrincipal();
        //查询总条数
        int total = signMapper.queryForCount(qo,currentUser.getId());
        if (total == 0) {
            return new PageResult();
        }
        //查询分页数据
        List<Sign> rows = signMapper.queryForList(qo,currentUser.getId());
        return new PageResult(total, rows);
    }

    @Override
    public void signIn() {
        Sign sign = new Sign();
        Date date = new Date();
        sign.setSignIn(date);
        Employee currentUser = (Employee) SecurityUtils.getSubject().getPrincipal();
        sign.setEmployee(currentUser);
        if (SignTimeUtil.isBelong()) {
            sign.setSignInState(Sign.SIGN_IN_Error);
        } else {
            sign.setSignInState(Sign.SIGN_IN_NORMAL);
        }
        signMapper.insert(sign);


    }

    @Override
    public void signOut() {
        Sign sign = new Sign();
        Date date = new Date();
        sign.setSignOut(date);
        Employee currentUser = (Employee) SecurityUtils.getSubject().getPrincipal();
        sign.setEmployee(currentUser);
        if (SignTimeUtil.isBelong()) {
            sign.setSignOutState(Sign.SIGN_OUT_Error);
        } else {
            sign.setSignOutState(Sign.SIGN_OUT_NORMAL);
        }
        signMapper.insert(sign);
    }

}
