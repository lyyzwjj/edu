package cn.wolfcode.edu.shiro;

import cn.wolfcode.edu.domain.Employee;
import cn.wolfcode.edu.domain.Role;
import cn.wolfcode.edu.service.IEmployeeService;
import cn.wolfcode.edu.service.IPermissionService;
import cn.wolfcode.edu.service.IRoleService;
import lombok.Setter;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import java.util.ArrayList;
import java.util.List;

public class EmployeeRealm extends AuthorizingRealm {

    @Setter
    private IEmployeeService employeeService;
    @Setter
    private IRoleService roleService;
    @Setter
    private IPermissionService permissionService;

    @Override
    public String getName() {
        return "EmployeeRealm";
    }

    //验证
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        //获取页面传入的用户名
        //登陆
        String name = (String) token.getPrincipal();
        //根据用户名查询数据库
        Employee employee =null;
        try {
            employee = employeeService.checkName(name);

        }catch (Exception e){
            e.printStackTrace();
        }
        if (employee == null) {
            return null;
        }
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(employee, employee.getPassword(), getName());
        return info;

    }

    //授权
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {

        //获取当前登陆的用户信息id
        Employee currentUser = (Employee) principals.getPrimaryPrincipal();
        List<String> roles = new ArrayList<>();
        List<String> permissions = new ArrayList<>();
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        //根据用户id获取期角色信息跟权限信息
        //判断是否是超级管理员
        if (currentUser.getAdmin()) {
            List<Role> list = roleService.list();
            for (Role role : list) {
                roles.add(role.getSn());
            }
            //权限
            permissions.add("*:*");
        } else {
            roles = roleService.queryRoleSnByEmployeeId(currentUser.getId());
            permissions = permissionService.selectAllResourcesByEmployeeId(currentUser.getId());
        }
        //3:将信息封装info对象,进行下一步操作
        info.addRoles(roles);
        info.addStringPermissions(permissions);
        return info;
    }

    //清除缓存
    public void clearCached() {
        PrincipalCollection principals = SecurityUtils.getSubject().getPrincipals();
        super.clearCache(principals);
    }
}
