package nexttrip.app.domain.mapper;


import nexttrip.app.domain.dto.FinanceDetailDto;
import nexttrip.app.domain.entity.Finance;
import nexttrip.app.domain.entity.Trip;
import nexttrip.fw.mapper.EntityMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FinanceDetailMapper extends EntityMapper<FinanceDetailDto, Finance> {
    FinanceDetailDto toDto(Finance finance);

}
