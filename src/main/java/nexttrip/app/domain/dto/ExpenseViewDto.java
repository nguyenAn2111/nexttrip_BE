package nexttrip.app.domain.dto;

import lombok.Data;
import nexttrip.app.common.enums.FinanceType;

import java.math.BigDecimal;

@Data
public class ExpenseViewDto {
    private String content;
    private FinanceType type;
    private BigDecimal cost;
    private String payer;
    private String note;
}
