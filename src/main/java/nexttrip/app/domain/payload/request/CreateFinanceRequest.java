package nexttrip.app.domain.payload.request;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class CreateFinanceRequest {

    private BigDecimal stayPay;
    private BigDecimal movePay;
    private BigDecimal eatPay;
    private BigDecimal actPay;
    private BigDecimal otherPay;
//    private BigDecimal totalRevenue;

}
