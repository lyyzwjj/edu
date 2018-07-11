package cn.wolfcode.edu.query;

import com.alibaba.druid.util.StringUtils;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * Created by Hasee on 2018/7/11.
 */
@Setter
@Getter
public class ExpendBillQueryObject extends QueryObject{

    private String keyword;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date begindate;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date enddate;

    public String getKeyWord(){
        return StringUtils.isEmpty(keyword) ? null : "keyword";
    }

}
