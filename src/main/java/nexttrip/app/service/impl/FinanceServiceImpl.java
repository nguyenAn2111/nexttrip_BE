package nexttrip.app.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import nexttrip.app.domain.dto.ExpenseGeneralDto;
import nexttrip.app.domain.dto.ExpenseListDto;
import nexttrip.app.domain.dto.ExpenseViewDto;
import nexttrip.app.domain.dto.FinanceDetailDto;
import nexttrip.app.domain.entity.Expense;
import nexttrip.app.domain.entity.Finance;
import nexttrip.app.domain.mapper.ExpenseViewMapper;
import nexttrip.app.domain.payload.request.CreateExpenseRequest;
import nexttrip.app.domain.payload.request.CreateFinanceRequest;
import nexttrip.app.repository.ExpenseRepository;
import nexttrip.app.repository.FinanceRepository;
import nexttrip.app.service.FinanceService;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class FinanceServiceImpl implements FinanceService {

    private final FinanceRepository financeRepository;
    private final ExpenseRepository expenseRepository;
    private final ExpenseViewMapper expenseViewMapper;

    @Override
    public FinanceDetailDto getFinanceDetail (Integer tripId){
        Finance finance = financeRepository.findTopByTripIdOrderByFinanceIdDesc(tripId);

        if (finance == null) {
            return null;
        }

        FinanceDetailDto dto = new FinanceDetailDto();

        dto.setId(finance.getFinanceId());
        dto.setStayPay(finance.getStayPay());
        dto.setMovePay(finance.getMovePay());
        dto.setEatPay(finance.getEatPay());
        dto.setActPay(finance.getActPay());
        dto.setOtherPay(finance.getOtherPay());
        dto.setTotalPay(finance.getPlanTotal());
        dto.setTotalRevenue(finance.getTotalRevenue());

        return dto;
    }


    @Override
    public Integer createFinance (CreateFinanceRequest request, Integer tripId) {

        Finance finance = new Finance();
        finance.setTripId(tripId);
        finance.setStayPay(request.getStayPay());
        finance.setEatPay(request.getEatPay());
        finance.setMovePay(request.getMovePay());
        finance.setActPay(request.getActPay());
        finance.setOtherPay(request.getOtherPay());
//        finance.setTotalRevenue(request.getTotalRevenue());
        finance.setPlanTotal(finance.getStayPay().add(finance.getEatPay()).add(finance.getMovePay()).add(finance.getActPay()).add(finance.getOtherPay()));
        finance.setTotalRevenue(
                finance.getPlanTotal().multiply(new BigDecimal("1.1"))
        );
        financeRepository.save(finance);
        return finance.getFinanceId();
    }

    @Override
    public Integer createExpense (CreateExpenseRequest request,Integer tripId) {
        Expense expense = new Expense();
        expense.setTripId(tripId);
        expense.setContent(request.getContent());
        expense.setType(request.getType());
        expense.setCost(request.getCost());
        expense.setPayer(request.getPayer());
        expense.setNote(request.getNote());
        expense.setCreated_at(LocalDateTime.now());

        expenseRepository.save(expense);

//        BigDecimal total = expenseRepository.sumCostByTripId(tripId);
//
//        // cập nhật totalPay cho bản ghi vừa tạo
//        expense.setTotalPay(total);
//        expenseRepository.save(expense);
        return expense.getExpenseId();
    }

    @Override
    public ExpenseListDto getListExpense (Integer tripId){
        List<Expense> expenses = this.expenseRepository.findByTripId(tripId);

        ExpenseListDto listDto = new ExpenseListDto();
        listDto.setExpenses(expenseViewMapper.toDto(expenses));
        listDto.setTotalPay(expenseRepository.getTotalExpense(tripId));
        return listDto;
    }

    @Override
    public ExpenseGeneralDto getExpenseGeneral(Integer tripId) {

        List<Expense> expenses = expenseRepository.findByTripId(tripId);

        ExpenseGeneralDto dto = new ExpenseGeneralDto();

        // Khởi tạo = 0
        dto.setStayPay(BigDecimal.ZERO);
        dto.setMovePay(BigDecimal.ZERO);
        dto.setEatPay(BigDecimal.ZERO);
        dto.setActPay(BigDecimal.ZERO);
        dto.setOtherPay(BigDecimal.ZERO);

        BigDecimal total = BigDecimal.ZERO;

        for (Expense expense : expenses) {

            // cộng tổng
            total = total.add(expense.getCost());

            // cộng theo loại
            switch (expense.getType()) {

                case STAY:
                    dto.setStayPay(dto.getStayPay().add(expense.getCost()));
                    break;

                case MOVE:
                    dto.setMovePay(dto.getMovePay().add(expense.getCost()));
                    break;

                case EAT:
                    dto.setEatPay(dto.getEatPay().add(expense.getCost()));
                    break;

                case ACTIVITY:
                    dto.setActPay(dto.getActPay().add(expense.getCost()));
                    break;

                case OTHER:
                    dto.setOtherPay(dto.getOtherPay().add(expense.getCost()));
                    break;
            }
        }

        dto.setTotalPay(total);

        Finance finance = financeRepository.findTopByTripIdOrderByFinanceIdDesc(tripId);

        return dto;
    }


}
