package cn.wolfcode.edu.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * 封装员工的工作经历的类
 */
@Getter
@Setter
public class Work {

    private Long id;
    //所在公司
    private String company;
    //职业
    private String profession;
    //职务
    private String business;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date beginDate;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endDate;
    //备注
    private String remark;
    //对应的员工的id
    private Long staff_id;
}