package nexttrip.app.service;

import nexttrip.app.domain.dto.ActivtityViewDto;
import nexttrip.app.domain.dto.ItineraryViewDto;
import nexttrip.app.domain.entity.Itinerary;
import nexttrip.app.domain.payload.request.CreateActivityRequest;
import nexttrip.app.domain.payload.request.CreateItineraryRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ItineraryService {

    Integer createItinerary(CreateItineraryRequest request,Integer tripId);

    Integer createActivity(CreateActivityRequest request, Integer itineraryId);

    List<ItineraryViewDto> getListItinerary(Integer tripID);

    List<ActivtityViewDto> getListActivity (Integer ItineraryId);
}
