package nexttrip.app.domain.mapper.trip;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import nexttrip.app.domain.dto.trip.TripDetailDto;
import nexttrip.app.domain.entity.Trip;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-08-26T17:32:29+0700",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.19 (Ubuntu)"
)
@Component
public class TripDetailMapperImpl implements TripDetailMapper {

    @Override
    public Trip toEntity(TripDetailDto dto) {
        if ( dto == null ) {
            return null;
        }

        Trip trip = new Trip();

        trip.setId( dto.getId() );
        trip.setDestination( dto.getDestination() );
        trip.setCode( dto.getCode() );
        trip.setTitle( dto.getTitle() );
        trip.setDescription( dto.getDescription() );
        trip.setStartDate( dto.getStartDate() );
        trip.setEndDate( dto.getEndDate() );
        trip.setNumberMember( dto.getNumberMember() );

        return trip;
    }

    @Override
    public List<Trip> toEntity(List<TripDetailDto> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<Trip> list = new ArrayList<Trip>( dtoList.size() );
        for ( TripDetailDto tripDetailDto : dtoList ) {
            list.add( toEntity( tripDetailDto ) );
        }

        return list;
    }

    @Override
    public List<TripDetailDto> toDto(List<Trip> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<TripDetailDto> list = new ArrayList<TripDetailDto>( entityList.size() );
        for ( Trip trip : entityList ) {
            list.add( toDto( trip ) );
        }

        return list;
    }

    @Override
    public void partialUpdate(Trip entity, TripDetailDto dto) {
        if ( dto == null ) {
            return;
        }

        if ( dto.getId() != null ) {
            entity.setId( dto.getId() );
        }
        if ( dto.getDestination() != null ) {
            entity.setDestination( dto.getDestination() );
        }
        if ( dto.getCode() != null ) {
            entity.setCode( dto.getCode() );
        }
        if ( dto.getTitle() != null ) {
            entity.setTitle( dto.getTitle() );
        }
        if ( dto.getDescription() != null ) {
            entity.setDescription( dto.getDescription() );
        }
        if ( dto.getStartDate() != null ) {
            entity.setStartDate( dto.getStartDate() );
        }
        if ( dto.getEndDate() != null ) {
            entity.setEndDate( dto.getEndDate() );
        }
        if ( dto.getNumberMember() != null ) {
            entity.setNumberMember( dto.getNumberMember() );
        }
    }

    @Override
    public TripDetailDto toDto(Trip trip) {
        if ( trip == null ) {
            return null;
        }

        TripDetailDto tripDetailDto = new TripDetailDto();

        tripDetailDto.setCode( trip.getCode() );
        tripDetailDto.setId( trip.getId() );
        tripDetailDto.setTitle( trip.getTitle() );
        tripDetailDto.setDestination( trip.getDestination() );
        tripDetailDto.setStartDate( trip.getStartDate() );
        tripDetailDto.setEndDate( trip.getEndDate() );
        tripDetailDto.setNumberMember( trip.getNumberMember() );
        tripDetailDto.setDescription( trip.getDescription() );

        return tripDetailDto;
    }
}
