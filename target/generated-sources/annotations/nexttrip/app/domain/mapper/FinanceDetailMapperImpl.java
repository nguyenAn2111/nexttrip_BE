package nexttrip.app.domain.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import nexttrip.app.domain.dto.FinanceDetailDto;
import nexttrip.app.domain.entity.Finance;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-08-26T17:32:30+0700",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.19 (Ubuntu)"
)
@Component
public class FinanceDetailMapperImpl implements FinanceDetailMapper {

    @Override
    public Finance toEntity(FinanceDetailDto dto) {
        if ( dto == null ) {
            return null;
        }

        Finance finance = new Finance();

        finance.setStayPay( dto.getStayPay() );
        finance.setMovePay( dto.getMovePay() );
        finance.setEatPay( dto.getEatPay() );
        finance.setActPay( dto.getActPay() );
        finance.setOtherPay( dto.getOtherPay() );
        finance.setTotalRevenue( dto.getTotalRevenue() );

        return finance;
    }

    @Override
    public List<Finance> toEntity(List<FinanceDetailDto> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<Finance> list = new ArrayList<Finance>( dtoList.size() );
        for ( FinanceDetailDto financeDetailDto : dtoList ) {
            list.add( toEntity( financeDetailDto ) );
        }

        return list;
    }

    @Override
    public List<FinanceDetailDto> toDto(List<Finance> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<FinanceDetailDto> list = new ArrayList<FinanceDetailDto>( entityList.size() );
        for ( Finance finance : entityList ) {
            list.add( toDto( finance ) );
        }

        return list;
    }

    @Override
    public void partialUpdate(Finance entity, FinanceDetailDto dto) {
        if ( dto == null ) {
            return;
        }

        if ( dto.getStayPay() != null ) {
            entity.setStayPay( dto.getStayPay() );
        }
        if ( dto.getMovePay() != null ) {
            entity.setMovePay( dto.getMovePay() );
        }
        if ( dto.getEatPay() != null ) {
            entity.setEatPay( dto.getEatPay() );
        }
        if ( dto.getActPay() != null ) {
            entity.setActPay( dto.getActPay() );
        }
        if ( dto.getOtherPay() != null ) {
            entity.setOtherPay( dto.getOtherPay() );
        }
        if ( dto.getTotalRevenue() != null ) {
            entity.setTotalRevenue( dto.getTotalRevenue() );
        }
    }

    @Override
    public FinanceDetailDto toDto(Finance finance) {
        if ( finance == null ) {
            return null;
        }

        FinanceDetailDto financeDetailDto = new FinanceDetailDto();

        financeDetailDto.setStayPay( finance.getStayPay() );
        financeDetailDto.setMovePay( finance.getMovePay() );
        financeDetailDto.setEatPay( finance.getEatPay() );
        financeDetailDto.setActPay( finance.getActPay() );
        financeDetailDto.setOtherPay( finance.getOtherPay() );
        financeDetailDto.setTotalRevenue( finance.getTotalRevenue() );

        return financeDetailDto;
    }
}
