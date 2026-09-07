package nexttrip.app.domain.mapper.trip;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.annotation.processing.Generated;
import nexttrip.app.domain.dto.trip.TripViewDto;
import nexttrip.app.domain.entity.Trip;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-08-26T17:32:30+0700",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.19 (Ubuntu)"
)
@Component
public class TripViewMapperImpl implements TripViewMapper {

    @Override
    public Trip toEntity(TripViewDto dto) {
        if ( dto == null ) {
            return null;
        }

        Trip trip = new Trip();

        trip.setDestination( dto.getDestination() );
        trip.setCode( dto.getCode() );
        byte[] image = dto.getImage();
        if ( image != null ) {
            trip.setImage( Arrays.copyOf( image, image.length ) );
        }
        trip.setTitle( dto.getTitle() );
        trip.setStatus( dto.getStatus() );

        return trip;
    }

    @Override
    public List<Trip> toEntity(List<TripViewDto> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<Trip> list = new ArrayList<Trip>( dtoList.size() );
        for ( TripViewDto tripViewDto : dtoList ) {
            list.add( toEntity( tripViewDto ) );
        }

        return list;
    }

    @Override
    public void partialUpdate(Trip entity, TripViewDto dto) {
        if ( dto == null ) {
            return;
        }

        if ( dto.getDestination() != null ) {
            entity.setDestination( dto.getDestination() );
        }
        if ( dto.getCode() != null ) {
            entity.setCode( dto.getCode() );
        }
        byte[] image = dto.getImage();
        if ( image != null ) {
            entity.setImage( Arrays.copyOf( image, image.length ) );
        }
        if ( dto.getTitle() != null ) {
            entity.setTitle( dto.getTitle() );
        }
        if ( dto.getStatus() != null ) {
            entity.setStatus( dto.getStatus() );
        }
    }

    @Override
    public TripViewDto toDto(Trip entity) {
        if ( entity == null ) {
            return null;
        }

        TripViewDto tripViewDto = new TripViewDto();

        tripViewDto.setTrip_id( entity.getId() );
        tripViewDto.setEnd_date( entity.getEndDate() );
        tripViewDto.setStart_date( entity.getStartDate() );
        tripViewDto.setNumber_member( entity.getNumberMember() );
        tripViewDto.setCode( entity.getCode() );
        byte[] image = entity.getImage();
        if ( image != null ) {
            tripViewDto.setImage( Arrays.copyOf( image, image.length ) );
        }
        tripViewDto.setTitle( entity.getTitle() );
        tripViewDto.setDestination( entity.getDestination() );
        tripViewDto.setStatus( entity.getStatus() );

        return tripViewDto;
    }

    @Override
    public List<TripViewDto> toDto(List<Trip> entity) {
        if ( entity == null ) {
            return null;
        }

        List<TripViewDto> list = new ArrayList<TripViewDto>( entity.size() );
        for ( Trip trip : entity ) {
            list.add( toDto( trip ) );
        }

        return list;
    }
}
