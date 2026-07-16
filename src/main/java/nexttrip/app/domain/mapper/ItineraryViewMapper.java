package nexttrip.app.domain.mapper;

import nexttrip.app.domain.dto.ItineraryViewDto;
import nexttrip.app.domain.entity.Itinerary;
import nexttrip.fw.mapper.EntityMapper;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ItineraryViewMapper extends EntityMapper<ItineraryViewDto, Itinerary> {
    ItineraryViewDto toDto (Itinerary itinerary);
    List<ItineraryViewDto> toDto(List<Itinerary> itineraries);
}
