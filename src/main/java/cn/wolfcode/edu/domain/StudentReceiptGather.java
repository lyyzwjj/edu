package cn.wolfcode.edu.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.List;

@Setter
@Getter
@ToString
public class StudentReceiptGather {
    private Long id;

    private List<ReceiptBill> receiptbills;

    private BigDecimal totalreceiptmoney;

    private BigDecimal totalmoney;

    private BigDecimal unpaidmoney;
}