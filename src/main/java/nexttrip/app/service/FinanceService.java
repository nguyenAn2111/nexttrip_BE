package nexttrip.app.service;

import nexttrip.app.domain.dto.ExpenseGeneralDto;
import nexttrip.app.domain.dto.ExpenseListDto;
import nexttrip.app.domain.dto.ExpenseViewDto;
import nexttrip.app.domain.dto.FinanceDetailDto;
import nexttrip.app.domain.entity.Expense;
import nexttrip.app.domain.entity.Finance;
import nexttrip.app.domain.payload.request.CreateExpenseRequest;
import nexttrip.app.domain.payload.request.CreateFinanceRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface FinanceService {

    Integer createFinance(CreateFinanceRequest request, Integer tripId);

    FinanceDetailDto getFinanceDetail (Integer tripId);

    Integer createExpense (CreateExpenseRequest request, Integer tripId);

    ExpenseListDto getListExpense (Integer tripId);

    ExpenseGeneralDto getExpenseGeneral (Integer tripId);



}
