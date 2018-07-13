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
    /*
    考试类型
     */
    private DataDictionaryItem examType;
    /*
    意向学科
     */
    private DataDictionaryItem intentionClass;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT-8")
    private Date examDate;

    private int passExam=PASS_EXAM_DEFAULT;

    private Employee saleMan;
    /*
    登记考试人员就是当前的登录人
     */
    private Employee inputMan;

    private String remark;

}