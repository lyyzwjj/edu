package cn.wolfcode.edu.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
@Getter@Setter
public class ClientMajor {
    private Long id;

    private String name;

    //=========================关联数据字典的字段  开始==================
    /*
    重要程度
     */
    private DataDictionaryItem importantDegree;
    /*
    意向程度
     */
    private DataDictionaryItem intentionDegree;
    /*
    意向学科
     */
    private DataDictionaryItem intentionClass;
    /*
    意向校区
     */
    private DataDictionaryItem intentionSchool;
    /*
    规定学历
   */
    private DataDictionaryItem academicDiplomas;
    /*
    学校体制
   */
    private DataDictionaryItem schoolSystem;
    /*
   办学性质
  */
    private DataDictionaryItem natureOfSchool;

    //=========================关联数据字典的字段  结束=========================

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
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date pervTraceDate;
    /*
    下次跟踪时间
   */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
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