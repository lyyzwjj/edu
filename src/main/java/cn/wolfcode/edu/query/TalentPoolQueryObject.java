package cn.wolfcode.edu.query;

import com.alibaba.druid.util.StringUtils;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Getter
@Setter
public class TalentPoolQueryObject extends QueryObject{

    private String sort; //排序的列
    private String order; //排序的方式
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date beginDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endDate;

    public String getSrot(){

        return StringUtils.isEmpty(sort) ?null :sort;
    }

    public String getOrder(){
        return StringUtils.isEmpty(order) ? "": order;
        //order没值时,是""不然拼接不起来
    }



}
