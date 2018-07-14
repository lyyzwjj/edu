package cn.wolfcode.edu.util;

import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.HandlerMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by WangZhe on 2018/7/9.
 */
@ControllerAdvice
public class ExceptionsHandlerUtil {
    @ExceptionHandler(UnauthorizedException.class)
    public void handleException(HandlerMethod method, HttpServletRequest request,
                                HttpServletResponse response) throws IOException{
        ResponseBody anno = method.getMethodAnnotation(ResponseBody.class);
        if (anno != null){
            response.setContentType("text/json:charset=utf-8");
            response.getWriter().write("{\"success\":false,\"errorMsg\":\"没有操作权限\"}");
        }else{
            response.sendRedirect("/nopermission.jsp");
        }
    }
}
