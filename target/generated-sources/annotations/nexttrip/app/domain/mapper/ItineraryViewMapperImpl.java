package nexttrip.app.domain.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import nexttrip.app.domain.dto.ItineraryViewDto;
import nexttrip.app.domain.entity.Itinerary;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-08-26T17:32:30+0700",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.19 (Ubuntu)"
)
@Component
public class ItineraryViewMapperImpl implements ItineraryViewMapper {

    @Override
    public Itinerary toEntity(ItineraryViewDto dto) {
        if ( dto == null ) {
            return null;
        }

        Itinerary itinerary = new Itinerary();

        itinerary.setItineraryId( dto.getItineraryId() );
        itinerary.setTripId( dto.getTripId() );
        itinerary.setDayNumber( dto.getDayNumber() );
        itinerary.setDate( dto.getDate() );
        itinerary.setTitle( dto.getTitle() );

        return itinerary;
    }

    @Override
    public List<Itinerary> toEntity(List<ItineraryViewDto> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<Itinerary> list = new ArrayList<Itinerary>( dtoList.size() );
        for ( ItineraryViewDto itineraryViewDto : dtoList ) {
            list.add( toEntity( itineraryViewDto ) );
        }

        return list;
    }

    @Override
    public void partialUpdate(Itinerary entity, ItineraryViewDto dto) {
        if ( dto == null ) {
            return;
        }

        if ( dto.getItineraryId() != null ) {
            entity.setItineraryId( dto.getItineraryId() );
        }
        if ( dto.getTripId() != null ) {
            entity.setTripId( dto.getTripId() );
        }
        if ( dto.getDayNumber() != null ) {
            entity.setDayNumber( dto.getDayNumber() );
        }
        if ( dto.getDate() != null ) {
            entity.setDate( dto.getDate() );
        }
        if ( dto.getTitle() != null ) {
            entity.setTitle( dto.getTitle() );
        }
    }

    @Override
    public ItineraryViewDto toDto(Itinerary itinerary) {
        if ( itinerary == null ) {
            return null;
        }

        ItineraryViewDto itineraryViewDto = new ItineraryViewDto();

        itineraryViewDto.setTripId( itinerary.getTripId() );
        itineraryViewDto.setTitle( itinerary.getTitle() );
        itineraryViewDto.setDate( itinerary.getDate() );
        itineraryViewDto.setDayNumber( itinerary.getDayNumber() );
        itineraryViewDto.setItineraryId( itinerary.getItineraryId() );

        return itineraryViewDto;
    }

    @Override
    public List<ItineraryViewDto> toDto(List<Itinerary> itineraries) {
        if ( itineraries == null ) {
            return null;
        }

        List<ItineraryViewDto> list = new ArrayList<ItineraryViewDto>( itineraries.size() );
        for ( Itinerary itinerary : itineraries ) {
            list.add( toDto( itinerary ) );
        }

        return list;
    }
}
