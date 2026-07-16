package nexttrip.app.service;

import io.swagger.v3.oas.annotations.servers.Server;
import nexttrip.app.domain.dto.trip.TripDetailDto;
import nexttrip.app.domain.dto.trip.TripViewDto;
import nexttrip.app.domain.entity.Trip;
import nexttrip.app.domain.payload.request.CreateTripRequest;
import nexttrip.app.domain.payload.request.UpdateTripRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TripService {

    Integer createTrip(CreateTripRequest request);

    List<TripViewDto> getListTrip();

    List<TripViewDto> getHomeTrip();

    TripDetailDto getTripDetail(Integer id);

    TripDetailDto updateTrip(Integer tripId, UpdateTripRequest request);

    boolean deleteTrip(Integer tripId);
}
