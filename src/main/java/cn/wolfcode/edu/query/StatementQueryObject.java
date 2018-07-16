package cn.wolfcode.edu.query;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
@Getter@Setter
public class StatementQueryObject {
    private String keyword;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date beginDate;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date endDate;
    private String groupByType="c.name";
    public String getGroupByType() {
        if(groupByType==null||groupByType.trim().length()==0) {
            return null;
        }
        return groupByType;
    }

    public static Map<String, String> groupByTypes = new LinkedHashMap<>();
    static{
        groupByTypes.put("c.name","正式成员");
        groupByTypes.put("p.payname","支付方式");
        groupByTypes.put("g.name","意向班级");
    }
}
