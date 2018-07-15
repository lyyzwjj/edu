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
    /*
    2表示为资源池客户
     */
    public static final int STATE_UNDETERMINED=2;
    /*
    3表示为休学学生
     */
    public static final int STATE_QUIT=3;
    /*
    4表示为学生流失
     */
    public static final int STATE_LOSSING=4;

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


    private String weChatNum;

    private String QQNum;

    private String tel;
    /*
    客户学校
    */
    private String school;
    /*
  学校客户选择其学校
   */
    private ClientMajor clientMajor;

    //===============关联数据字典的==============
    /*
    意向程度
     */
    private DataDictionaryItem degreeOfIntention;
    /*
     意向校区
     */
    private DataDictionaryItem intentionSchool;
    /*
    意向班级/课程
     */
    private DataDictionaryItem intentionClass;

    /*
    客户来源
     */
    private DataDictionaryItem sourceOfClient;
    /*
   客户的学历
   */
    private DataDictionaryItem education;
    /*
   客户家乡
    */
    private DataDictionaryItem hometown;

    /*
    客户当前自身的状态
     */
    private DataDictionaryItem clientState;
    /*
   专业
    */
    private DataDictionaryItem major;
    /*
    工作年限
     */
    private DataDictionaryItem yearsOfWorkExperience;

    //==============关联字典的结束=============
    /*
    客户的当前状态 潜在还是正式 设置默认值是潜在
     */
    private int stateId=STATE_DEFAULT;
    /*
    是否有人在跟进
     */
    private int isManTrace;
    /*
    备注
     */
    private String remark;
    /*
   最后跟踪日期
    */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date lastTraceDate;
    /*
    预约时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date bookDate;
    /*
    下一次跟踪时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date nextTraceDate;
    /*
    建档时间 实际与当前新增事录入时间一致
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date buildDate;
    /*
    录入时间 就是当前时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date inputDate;
    /*
    转正时间 就是点击转正之后设置进去的时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date transferDate;

    /*
    客户年龄
     */
    private Integer age;
    /*
    客户性别
     */
    private int gender;
    /*
    客户邮箱
    */
    private String email;
    /*
   客户地址
    */
    private String address;



    /*
   客户的大学入学时间
    */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date collegeAdmissionTime;

    /*
    介绍人姓名
     */
    private String introduceManId;
    /*
    付款状态
     */
    private int payStatusId;
    /*
    是否携带电脑 1:是 0:没有
     */
    private int withComputer;
    /*
    客户的关注点是什么
     */
    private String clientAttentionWhat;
    /*
     客户类型 线上 线下
      */
    private int clientTypeId;

    /*
    接收人员 就是转移记录中的现追踪人
     */
    private Employee acceptMan;

    /*
    客户收款信息
     */
    private StudentReceiptGather studentReceiptGather;
    private ReceiptBill receiptBill;

}