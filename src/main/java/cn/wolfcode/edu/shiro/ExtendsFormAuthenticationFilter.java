package cn.wolfcode.edu.shiro;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


public class ExtendsFormAuthenticationFilter extends FormAuthenticationFilter {
    //登录成功处理方法
    protected boolean onLoginSuccess(AuthenticationToken token,
                                     Subject subject, ServletRequest request, ServletResponse response)
            throws Exception {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        resp.setCharacterEncoding("utf-8");
        PrintWriter out = resp.getWriter();
        out.println("{\"success\":true,\"msg\":\"登陆成功\"}");
        out.flush();
        out.close();
        return false;
    }
    //登陆失败处理方法
    protected boolean onLoginFailure(AuthenticationToken token,
                                     AuthenticationException e, ServletRequest request,
                                     ServletResponse response) {
        try {
            response.setCharacterEncoding("utf-8");
            PrintWriter out = response.getWriter();
            String message = e.getClass().getSimpleName();
            if ("IncorrectCredentialsException".equals(message)) {
                out.println("{\"success\":false,\"msg\":\"密码错误\"}");
            } else if ("UnknownAccountException".equals(message)) {
                out.println("{\"success\":false,\"msg\":\"账号不存在\"}");
            } else if ("LockedAccountException".equals(message)) {
                out.println("{\"success\":false,\"msg\":\"账号被锁定\"}");
            } else if ("AuthenticationException".equals(message)) {
                out.println("{\"success\":false,\"msg\":\"账号被锁定\"}");
            } else {
                out.println("{\"success\":false,\"msg\":\"位置错误\"}");
            }
            out.flush();
            out.close();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        return false;
    }

}

