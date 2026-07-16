package nexttrip.app.domain.mapper.trip;

import nexttrip.app.domain.dto.trip.TripDetailDto;
import nexttrip.app.domain.entity.Trip;
import nexttrip.fw.mapper.EntityMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TripDetailMapper extends EntityMapper<TripDetailDto, Trip> {
    @Mapping(target="code", source = "code")
    TripDetailDto toDto(Trip trip);

}
