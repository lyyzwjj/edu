package cn.wolfcode.edu.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
@Getter@Setter
public class ClientSchoolLinkman {
    private Long id;

    private String name;

    private int gender;
    /*
    关联大客户表 学校名字
     */
    private ClientMajor schoolName;
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;

    private String department;
    /*
    职位
     */
    private String job;

    private String tel;

    private String qq;

    private String weChat;

    private String email;
    /*
    是否为主联系人
     */
    private int isMajorLinkman;

    private String introduce;

}