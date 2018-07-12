package cn.wolfcode.edu.query;

import com.alibaba.druid.util.StringUtils;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CourseNameQueryObject extends QueryObject{
    private String keyword;//根据课程名称或者课程所属系列查询


    public String getKeyword(){

        return StringUtils.isEmpty(keyword) ? null :keyword;
    }

}
