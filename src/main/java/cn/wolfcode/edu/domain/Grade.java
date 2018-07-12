package cn.wolfcode.edu.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Grade {
    public static final int STATE_NORMAL = 1; //毕业
    public static final int STATE_AUDITED = 0; //未毕业

    private Long id;

    private String name;

    //班主任
    private Employee classTeacher;

    //课程表,一对多
    private List<CourseName> courseName =new ArrayList<>();

    private int state;

}