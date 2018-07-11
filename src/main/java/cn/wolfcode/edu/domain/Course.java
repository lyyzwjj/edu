package cn.wolfcode.edu.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Course {
    public static final int STATE_NORMAL = 1; //毕业
    public static final int STATE_AUDITED = 0; //未毕业

    private Long id;

    private String name;

    //课程顺序
    private int sequence;

    //课程日期
    private Date coursedate;

    //星期几
    private Date week;

    //班主任
    private Employee classTeacher;

    //上课教师
    private Employee courseTeacher;

    //教师
    private ClassRoom classroom;

    //备注
    private String remark;

    private int state;
}
