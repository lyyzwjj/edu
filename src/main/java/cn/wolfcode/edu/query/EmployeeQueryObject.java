package cn.wolfcode.edu.query;

import com.alibaba.druid.util.StringUtils;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Setter
@Getter
public class EmployeeQueryObject extends QueryObject {

    //通过关键字查询(用户名或密码)
    private String keyword;

    //通过入职时间查询
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date beginDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endDate;

    /**
     * 以下代码为排序使用
     */
    private String sort;//排序的列
    private String order;//排序的方式

    public String getSort() {
        return StringUtils.isEmpty(sort) ? null : sort;
    }

    public String getOrder() {
        return StringUtils.isEmpty(order) ? "" : order;
    }
}
