package cn.wolfcode.edu.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Getter@Setter
public class ClientSchoolLinkman {
    private Long id;

    private String name;

    private Integer gender;
    /*
    关联大客户表 学校名字
     */
    private ClientMajor schoolName;

    private Date birthday;

    private String department;
    /*
    职位
     */
    private String job;

    private String tel;

    private String QQ;

    private String weChat;

    private String email;
    /*
    是否为主联系人
     */
    private int isMajorLinkman;

    private String introduce;

}