package nexttrip.app.domain.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import nexttrip.app.domain.dto.ExpenseViewDto;
import nexttrip.app.domain.entity.Expense;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-08-26T17:32:30+0700",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.19 (Ubuntu)"
)
@Component
public class ExpenseViewMapperImpl implements ExpenseViewMapper {

    @Override
    public Expense toEntity(ExpenseViewDto dto) {
        if ( dto == null ) {
            return null;
        }

        Expense expense = new Expense();

        expense.setContent( dto.getContent() );
        expense.setType( dto.getType() );
        expense.setCost( dto.getCost() );
        expense.setPayer( dto.getPayer() );
        expense.setNote( dto.getNote() );

        return expense;
    }

    @Override
    public List<Expense> toEntity(List<ExpenseViewDto> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<Expense> list = new ArrayList<Expense>( dtoList.size() );
        for ( ExpenseViewDto expenseViewDto : dtoList ) {
            list.add( toEntity( expenseViewDto ) );
        }

        return list;
    }

    @Override
    public void partialUpdate(Expense entity, ExpenseViewDto dto) {
        if ( dto == null ) {
            return;
        }

        if ( dto.getContent() != null ) {
            entity.setContent( dto.getContent() );
        }
        if ( dto.getType() != null ) {
            entity.setType( dto.getType() );
        }
        if ( dto.getCost() != null ) {
            entity.setCost( dto.getCost() );
        }
        if ( dto.getPayer() != null ) {
            entity.setPayer( dto.getPayer() );
        }
        if ( dto.getNote() != null ) {
            entity.setNote( dto.getNote() );
        }
    }

    @Override
    public ExpenseViewDto toDto(Expense expense) {
        if ( expense == null ) {
            return null;
        }

        ExpenseViewDto expenseViewDto = new ExpenseViewDto();

        expenseViewDto.setContent( expense.getContent() );
        expenseViewDto.setType( expense.getType() );
        expenseViewDto.setCost( expense.getCost() );
        expenseViewDto.setPayer( expense.getPayer() );
        expenseViewDto.setNote( expense.getNote() );

        return expenseViewDto;
    }

    @Override
    public List<ExpenseViewDto> toDto(List<Expense> expenses) {
        if ( expenses == null ) {
            return null;
        }

        List<ExpenseViewDto> list = new ArrayList<ExpenseViewDto>( expenses.size() );
        for ( Expense expense : expenses ) {
            list.add( toDto( expense ) );
        }

        return list;
    }
}
