package cn.wolfcode.edu.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

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
    private String QQ;
    //地址
    private String address;
    //工号
    private Long employeeId;
    //考勤卡号
    private Long attendanceid;
    //入职日期
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date hireDate;
    //工龄
    private Integer seniority;
    //状态:1表示在职,0 表示离职
    private Boolean state;
    //头像(数据库中的为地址)
    private String portrait;
    //是否为超级管理员
    private Boolean admin;
    //所属部门
    private Long deptId;
}