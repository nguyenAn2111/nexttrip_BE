package nexttrip.app.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import nexttrip.app.domain.dto.ActivtityViewDto;
import nexttrip.app.domain.dto.ItineraryViewDto;
import nexttrip.app.domain.entity.Activity;
import nexttrip.app.domain.entity.Itinerary;
import nexttrip.app.domain.entity.Trip;
import nexttrip.app.domain.mapper.ActivityViewMapper;
import nexttrip.app.domain.mapper.ItineraryViewMapper;
import nexttrip.app.domain.payload.request.CreateActivityRequest;
import nexttrip.app.domain.payload.request.CreateItineraryRequest;
import nexttrip.app.domain.payload.request.CreateTripRequest;
import nexttrip.app.repository.ActivityRepository;
import nexttrip.app.repository.ItineraryRepository;
import nexttrip.app.repository.TripRepository;
import nexttrip.app.service.ItineraryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ItineraryServiceImpl implements ItineraryService {

    private final ItineraryRepository itineraryRepository;
    private final ActivityRepository activityRepository;
    private final ItineraryViewMapper itineraryViewMapper;
    private final ActivityViewMapper activityViewMapper;
    private final TripRepository tripRepository;

    @Override
        public Integer createItinerary(CreateItineraryRequest request, Integer tripId) {

            Trip trip = tripRepository.findById(tripId)
                    .orElseThrow(() -> new RuntimeException("Trip not found"));

            Itinerary itinerary = new Itinerary();

            itinerary.setTitle(request.getTitle());
            itinerary.setDayNumber(request.getDayNumber());
            itinerary.setDate(request.getDate());
            itinerary.setTripId(trip);

            itineraryRepository.save(itinerary);

            return itinerary.getItineraryId();
    }

    @Override
    public Integer createActivity (CreateActivityRequest request, Integer itineraryId) {
        Itinerary itinerary = itineraryRepository.findById(itineraryId)
                .orElseThrow(() -> new RuntimeException("Itinerary not found"));
        Activity activity = new Activity();

        activity.setItineraryId(itinerary);
        activity.setName(request.getName());
        activity.setNote(request.getNote());
        activity.setStartTime(request.getStartTime());
        activity.setEndTime(request.getEndTime());
        activity.setLocation(request.getLocation());

        this.activityRepository.save(activity);
        return activity.getActivityId();
    }

    @Override
    public List<ItineraryViewDto> getListItinerary (Integer tripId) {
        return itineraryViewMapper.toDto(
                itineraryRepository.findByTripId_IdOrderByDayNumberAsc(tripId)
        );
    }

    @Override
    public List<ActivtityViewDto> getListActivity (Integer ItineraryId) {
        return activityViewMapper.toDto(
                activityRepository.findByItineraryId_ItineraryIdOrderByStartTimeAsc(ItineraryId)
        );
    }


}
