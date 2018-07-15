package cn.wolfcode.edu.query;

import com.alibaba.druid.util.StringUtils;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Getter@Setter
public class ClientQueryObject extends  QueryObject {
    private String keyword;

    @DateTimeFormat(pattern = "yyyy-MM-dd ")
    private Date begindate;
    @DateTimeFormat(pattern = "yyyy-MM-dd ")
    private Date enddate;

    public String getKeyWord(){
        return StringUtils.isEmpty(keyword) ? null : "keyword";
    }
}
