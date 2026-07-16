package nexttrip.app.domain.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ExpenseGeneralDto {

    private BigDecimal stayPay;
    private BigDecimal movePay;
    private BigDecimal eatPay;
    private BigDecimal actPay;
    private BigDecimal otherPay;

    private BigDecimal totalPay;

}
