package cn.wolfcode.edu.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
@Getter@Setter
public class ClientExam {
    /*
    默认没有通过考试
     */
    public static  final int PASS_EXAM_DEFAULT=0;
    /*
    1表示通过考试
     */
    public static  final int PASS_EXAM_YES=1;
    private Long id;

    private Client client;

    //-------------关联数据字典------------
    /*
    考试类型 id=27
     */
    private DataDictionaryItem examType;
    /*
    意向学科 id=17
     */
    private DataDictionaryItem intentionClass;

    //-------------------------------------------

    /*
    考试日期
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date examDate;
    /*
    通过考试的情况 默认是未通过
     */
    private int passExam=PASS_EXAM_DEFAULT;

    private Employee saleMan;
    /*
    登记考试人员就是当前的登录人
     */
    private Employee inputMan;

    private String remark;

}