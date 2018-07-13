package cn.wolfcode.edu.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Getter
@Setter
public class Course {
    public static final int STATE_NORMAL = 1; //已上
    public static final int STATE_AUDITED = 0; //未上

    private Long id;

    //关联课目表
    private CourseName courseName;

    //课程顺序
    private int sequence;

    //课程日期
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GTM+8")
    private Date courseDate;

    //星期几
    private String week;

    //班级
    private Grade grade;

    //班主任
    private Employee classTeacher;

    //上课教师
    private Employee courseTeacher;

    //教室
    private ClassRoom classroom;

    //备注
    private String remark;

    private int state =STATE_NORMAL;
}
