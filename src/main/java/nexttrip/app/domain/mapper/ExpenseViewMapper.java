package nexttrip.app.domain.mapper;

import nexttrip.app.domain.dto.ExpenseViewDto;
import nexttrip.app.domain.entity.Expense;
import nexttrip.fw.mapper.EntityMapper;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper (componentModel = "spring")
public interface ExpenseViewMapper extends EntityMapper<ExpenseViewDto, Expense> {
    ExpenseViewDto toDto(Expense expense);
    List<ExpenseViewDto> toDto (List<Expense> expenses);
}
