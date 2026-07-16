package nexttrip.app.domain.dto;

import lombok.Data;
import nexttrip.app.domain.entity.Expense;

import java.math.BigDecimal;
import java.util.List;

@Data
public class ExpenseListDto {
    private List<ExpenseViewDto> expenses;

    private BigDecimal totalPay;
}
