package cn.wolfcode.edu.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Getter@Setter
public class ClientMajor {
    private Long id;

    private String name;
    /*
    重要程度
     */
    private Long importantDegree;
    /*
    意向程度
     */
    private Long intentionDegree;
    /*
    意向班级/课程
     */
    private Long intentionClass;
    /*
    意向校区
     */
    private Long intentionSchool;
    /*
    校方联系人员
    */
    private ClientSchoolLinkman contactPerson;
    /*
    营销人员
   */
    private Employee saleMan;
    /*
    跟踪人员
   */
    private Employee traceMan;
    /*
    客户状态 线上1 线下0
   */
    private Long clientState;
    /*
    追踪状态 是否有人在追踪
   */
    private Long traceState;
    /*
    优惠政策
   */
    private String preferentialPolicy;
    /*
    上次跟踪日期
   */
    private Date pervTraceDate;
    /*
    下次跟踪时间
   */
    private Date nextTraceTime;
    /*
    地址
   */
    private String address;
    /*
    电话
   */
    private String tel;
    /*
    邮箱
   */
    private String email;
    /*
    办学性质
   */
    private Long natureOfSchool;
    /*
    规定学历
   */
    private Long academicDiplomas;
    /*
    学校体制
   */
    private Long schoolSystem;
    /*
    邮政编码
   */
    private String postcode;
    /*
    学校官网
   */
    private String website;
    /*
    学生总人数
   */
    private Integer studentTotal;
    /*
    it专业学生人数
   */
    private Integer stuentTotalIT;
    /*
    学校简介
   */
    private String schooIntroduce;
    /*
    备注
   */
    private String remark;

}