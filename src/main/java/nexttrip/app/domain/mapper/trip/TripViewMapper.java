package nexttrip.app.domain.mapper.trip;

import nexttrip.app.domain.dto.trip.TripViewDto;
import nexttrip.app.domain.entity.Trip;
import nexttrip.fw.mapper.EntityMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TripViewMapper extends EntityMapper<TripViewDto, Trip> {
    @Mapping(target = "trip_id", source="id")
    @Mapping(target = "end_date", source = "endDate")
    @Mapping(target = "start_date", source = "startDate")
    @Mapping(target = "number_member", source = "numberMember")
    @Mapping(target="code", source = "code")
    TripViewDto toDto(Trip entity);
    List<TripViewDto> toDto(List<Trip> entity);
}
