package cn.wolfcode.edu.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
@Getter@Setter
public class ClientTrace {

    private Long id;

    private Client name;

    private String email;

    private String qq;

    private String tel;
    /*
    客户自身当前状态
     */
    private String currentStateId;
    /*
    当前跟踪人员,就和client表中的追踪人员一致 inputMan
     */
    private Employee traceMan;
    //下次跟踪时间
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date nextTraceDate;
    /*
    客户的意向校区
     */
    private String intentionSchoolId;
    /*
   客户的意向班级
    */
    private String intentionClassId;
    /*
   交流目的
    */
    private String communicativePurposeId;
    /*
       交流方式
       */
    private String communicativeWayId;
    /*
   客户的意向程度
    */
    private String degreeOfIntentionId;
    /*
   最后一次跟踪
    */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date lastTraceDate;
    //追踪次数
    private Integer traceTimes;
    //摘要
    private String  contentAbstract;
    //交流内容
    private String communicationContent;
    //客户的状态 是否有人在跟踪
    private Integer status;

}