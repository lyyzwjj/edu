package cn.wolfcode.edu.util;

import cn.wolfcode.edu.domain.Employee;
import cn.wolfcode.edu.domain.Systemlog;
import cn.wolfcode.edu.service.ISystemlogService;
import lombok.Setter;
import org.apache.shiro.SecurityUtils;
import org.aspectj.lang.JoinPoint;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.Arrays;
import java.util.Date;

/**
 * Created by WangZhe on 2018/7/12.
 */
public class SystemlogAspect {
    @Setter
    private ISystemlogService systemlogService;

    public void write(JoinPoint jp) {
        //过滤systemlogService本身操作
        if (jp.getTarget() instanceof ISystemlogService) {
            return;
        }
        Systemlog systemlog = new Systemlog();
        systemlog.setOptime(new Date());
//        Employee employee = (Employee) SecurityUtils.getSubject().getPrincipal();
//        systemlog.setOpuser(employee);
        //没有配置shiro先用假用户
        Employee employee = new Employee();
        employee.setId(100L);
        employee.setUsername("admin");
        systemlog.setOpuser(employee);
        systemlog.setFunction(jp.getTarget().getClass().getName()
                + "." + jp.getSignature().getName());
        systemlog.setParams(Arrays.toString(jp.getArgs()));
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) requestAttributes;
        systemlog.setOplp(servletRequestAttributes.getRequest().getRemoteAddr());
        systemlogService.save(systemlog);
    }
}
