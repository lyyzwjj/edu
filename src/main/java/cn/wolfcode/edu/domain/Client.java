package cn.wolfcode.edu.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
@Setter
@Getter
public class Client {

    /*
    设置潜在客户的默认状态
     */
    public static final int STATE_DEFAULT=0;
    /*
    1表示为正式客户
     */
    public static final int STATE_FORMAL=1;

    private Long id;
    /*
    客户姓名
     */
    private String name;
    /*
      营销人员姓名
    */
    private Employee saleMan;
    /*
    当前跟踪人员 也是录入人
     */
    private Employee inputMan;
    /*
    跟踪次数
     */
    private int traceTimes;
    /*
    最后跟踪日期
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT-8")
    private Date lastTraceDate;
    /*
    预约时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT-8")
    private Date bookDate;
    /*
    下一次跟踪时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT-8")
    private Date nextTraceDate;

    private String weChatNum;

    private String QQNum;

    private String tel;
    /*
    客户学校
    */
    private String school;
    /*
    意向程度
     */
    private Long degreeOfIntentionId;
    /*
     意向校区
     */
    private Long intentionSchoolId;
    /*
    意向班级/课程
     */
    private Long intentionClassId;
    /*
    客户的当前状态 潜在还是正式
     */
    private int stateId;
    /*
    是否有人在跟进
     */
    private int isManTrace;
    /*
    备注
     */
    private String remark;
    /*
    建档时间 实际与当前新增事录入时间一致
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT-8")
    private Date buildDate;
    /*
    录入时间 就是当前时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT-8")
    private Date inputDate;
    /*
    客户来源
     */
    private Long sourceOfClientId;
    /*
    客户年龄
     */
    private Integer age;
    /*
    客户性别
     */
    private Integer gender;
    /*
    客户邮箱
    */
    private String email;
    /*
   客户地址
    */
    private String address;
    /*
   学校客户选择其学校
    */
    private Long schoolId;
    /*
    客户的学历
    */
    private Long educationId;
    /*
   客户家乡
    */
    private Long hometownId;
    /*
   客户的大学入学时间
    */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT-8")
    private Date collegeAdmissionTime;
    /*
    专业
     */
    private Long majorId;
    /*
    工作年限
     */
    private Long yearsOfWorkExperienceId;
    /*
    介绍人姓名
     */
    private Long introduceManId;
    /*
    付款状态
     */
    private Long payStatusId;
    /*
    是否携带电脑 1:是 0:没有
     */
    private Integer withComputer;
    /*
    客户的关注点是什么
     */
    private String clientAttentionWhat;
    /*
    客户类型
     */
    private Long clientTypeId;
    /*
    客户当前自身的状态
     */
    private int clientState;

    /*
    客户收款信息
     */
    private ReceiptBill receiptBill;

}