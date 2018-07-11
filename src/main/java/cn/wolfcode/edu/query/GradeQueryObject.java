package cn.wolfcode.edu.query;

import com.alibaba.druid.util.StringUtils;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GradeQueryObject extends QueryObject{
    private String keyword;//根据班级名称查询

    private String empId ;//根据班主任查询

    public String getKeyword(){

        return StringUtils.isEmpty(keyword) ? null :keyword;
    }

    public String getEmpId(){

        return StringUtils.isEmpty(empId) ? null :empId;
    }

}
