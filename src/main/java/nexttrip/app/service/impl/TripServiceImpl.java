package nexttrip.app.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import nexttrip.app.common.enums.TripStatus;
import nexttrip.app.domain.dto.trip.TripDetailDto;
import nexttrip.app.domain.dto.trip.TripViewDto;
import nexttrip.app.domain.entity.Trip;
import nexttrip.app.domain.mapper.trip.TripDetailMapper;
import nexttrip.app.domain.mapper.trip.TripViewMapper;
import nexttrip.app.domain.payload.request.CreateTripRequest;
import nexttrip.app.domain.payload.request.UpdateTripRequest;
import nexttrip.app.repository.TripRepository;
import nexttrip.app.service.TripService;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class TripServiceImpl implements TripService {

    private final TripRepository tripRepository;
    private final TripViewMapper tripViewMapper;
    private final TripDetailMapper tripDetailMapper;



    @Override
    public Integer createTrip(CreateTripRequest request){

        Trip trip = new Trip();
        trip.setTitle(request.getTitle());
        trip.setDescription(request.getDescription());
        trip.setImage(request.getImage());
        trip.setEndDate(request.getEnd_date());
        trip.setStartDate(request.getStart_date());
        trip.setStatus(TripStatus.PLANNING);
        trip.setOwnerId(1);
        trip.setNumberMember(1);
        trip.setCreatedAt(LocalDateTime.now());
        trip.setDestination(request.getDestination());
        trip.setCode(request.getCode());

        trip = this.tripRepository.save(trip);
        return trip.getId();
    }

    @Override
    public List<TripViewDto> getListTrip(){
        List<Trip> trips = tripRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
        return this.tripViewMapper.toDto(trips);
    }

    @Override
    public List<TripViewDto> getHomeTrip(){
        List<Trip> trips = tripRepository.findByStatusIn(
                List.of(TripStatus.PLANNING, TripStatus.PROCESSING)
        );
        return this.tripViewMapper.toDto(trips);
    }

    @Override
    public TripDetailDto getTripDetail(Integer id){
        Trip trip = tripRepository.findById(id).orElse(null);
        return this.tripDetailMapper.toDto(trip);
    }


    @Override
    public TripDetailDto updateTrip(Integer tripId, UpdateTripRequest request){
//        Trip existingTrip = tripRepository.findById(tripId).orElse(null);
//
////        if (this.tripRepository.existsById(tripId)) {
////            log.info("Trip already exists");
////        }
//
//        existingTrip.setTitle(request.getTitle());
//        existingTrip.setDescription(request.getDescription());
//        existingTrip.setEndDate(request.getEnd_date());
//        existingTrip.setStartDate(request.getStart_date());
//        existingTrip.setStatus(request.getTrip_status());
//        existingTrip.setDestination(request.getDestination());
//        existingTrip.setCode(request.getCode());
//
//        existingTrip = tripRepository.save(existingTrip);
//
//        TripDetailDto tripDetailDto = this.tripDetailMapper.toDto(existingTrip);
//        return tripDetailDto;
        System.out.println("TITLE REQUEST: " + request.getTitle());
        System.out.println("CODE REQUEST: " + request.getCode());
        System.out.println("DEST REQUEST: " + request.getDestination());
        System.out.println("DATE REQUEST: " + request.getStart_date());


        Trip existingTrip = tripRepository.findById(tripId)
                .orElseThrow();


        existingTrip.setTitle(request.getTitle());
        existingTrip.setDescription(request.getDescription());
        existingTrip.setEndDate(request.getEnd_date());
        existingTrip.setStartDate(request.getStart_date());
        existingTrip.setStatus(request.getTrip_status());
        existingTrip.setDestination(request.getDestination());
        existingTrip.setCode(request.getCode());


        existingTrip = tripRepository.save(existingTrip);


        System.out.println("AFTER SAVE TITLE: " + existingTrip.getTitle());
        System.out.println("AFTER SAVE CODE: " + existingTrip.getCode());


        return tripDetailMapper.toDto(existingTrip);
    }

    @Override
    public boolean deleteTrip(Integer tripId){

        Trip existingTrip = tripRepository.findById(tripId)
                .orElseThrow(() ->
                        new RuntimeException("Trip not found")
                );

        tripRepository.delete(existingTrip);

        return true;
    }
}
