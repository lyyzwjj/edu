package cn.wolfcode.edu.query;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Getter
@Setter
public class CourseQueryObject extends QueryObject{
    private Long gradeId = -1L;//根据班级名称查询

    private Long classRoomId = -1L; //根据教室名称查询

    private Long empId =-1L ;//根据班主任查询

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date begindate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date enddate;

}
