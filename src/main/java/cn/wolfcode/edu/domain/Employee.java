package cn.wolfcode.edu.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Setter
@Getter
public class Employee {
    //编号
    private Long id;
    //用户名
    private String username;
    //密码
    private String password;
    //真实姓名
    private String realname;
    //年龄
    private Integer age;
    //性别:1表示男,0表示女
    private Integer gender;
    //出生日期
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date bornDate;
    //身份证号码
    private Long cardId;
    //电话号码
    private String tel;
    //邮箱
    private String eamil;
    //QQ号码
    private String qq;
    //地址
    private String address;
    //工号
    private Long employeeId;
    //考勤卡号
    private Long attendanceId;
    //入职日期
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date hireDate;
    //工龄
    private Integer seniority;
    //状态:true表示在职,false 表示离职,默认为在职状态
    private Boolean state = true;
    //头像(数据库中的为地址)
    private String portrait;
    //是否为超级管理员
    private Boolean admin;
    //所属部门
    private Department dept;

    //多对多关系,维护与角色的关系
    private List<Role> roles = new ArrayList<>();

    //客户来源,于数据字典
    private Long sourceOfClientId;
}