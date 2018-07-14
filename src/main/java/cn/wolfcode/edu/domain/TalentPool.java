package cn.wolfcode.edu.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Getter
@Setter
public class TalentPool {
    private Long id;

    private String name;

    //应聘日期
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone ="GMT+8")
    private Date employDate;

    //应聘职务,于数据字典
    private DataDictionaryItem duty;

    //聘用类型,于数据字典
    private DataDictionaryItem hireType;

    //工作年限,于数据字典
    private DataDictionaryItem workYear;

    //学历要求,于数据字典
    private DataDictionaryItem education;

    //薪资要求,于数据字典
    private DataDictionaryItem recruitSalary;

    //相关技能
    private String recruitrequired;

    private String remark;

}