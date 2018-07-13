package cn.wolfcode.edu.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Setter
@Getter
@ToString
public class StudentTrend {
    private Long id;

    private int genre;

    private ReceiptBill receiptbill;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date exchangetime;

    private Grade oldclass;

    private Grade newclass;

    private Employee marketer;

    private int trendstate;

}