package cn.wolfcode.edu.shiro;

import cn.wolfcode.edu.domain.Employee;
import cn.wolfcode.edu.service.IEmployeeService;
import cn.wolfcode.edu.service.IPermissionService;
import cn.wolfcode.edu.service.IRoleService;
import lombok.Setter;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

public class EmployeeRealm extends AuthorizingRealm{

    @Setter
    private IEmployeeService employeeService;
    @Setter
    private IRoleService roleService;
    @Setter
    private IPermissionService permissionService;
    public String getName() {
        return "EmployeeRealm";
    }
    //验证
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        //获取页面传入的用户名
        //登陆
        String username = (String)token.getPrincipal();

      //  employeeService.getEmployeeByUserName(username);
        //根据用户名查询数据库
        Employee employee1 = employeeService.get(1L);
        if(employee1 != null){}
        System.out.println(employee1.getUsername());
        Employee employee = employeeService.checkName(username);
         if(employee==null){
            return null;
        }
        System.out.println("duixang"+employee+ new SimpleAuthenticationInfo(employee,employee.getPassword(),getName()));
        return new SimpleAuthenticationInfo(employee,employee.getPassword(),getName());

    }
    //授权
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {

    //获取当前登陆的用户信息id
   /* Employee currentEmp =(Employee) principals.getPrimaryPrincipal();

    List<String> roles =null;
    List<String> permissions=null;
    //根据用户id获取期角色信息跟权限信息
        //判断是否是超级管理员
    if (currentEmp.isAdmin()){
        List<Role> list = roleService.list();
        for (Role role : list) {
            roles.add(role.getSn());
        }

        //权限
        permissions= new ArrayList<>();
        permissions.add("*:*");
    }else{
        roles=roleService.queryRoleSnByEmpId(currentEmp.getId());
        permissions=permissionService.queryPermissionResourceByEmpId(currentEmp.getId());
    }
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        //3:将信息封装info对象,进行下一步操作
        info.addRoles(roles);
        info.addStringPermissions(permissions);*/

        //return info;
        return null;
    }
}
