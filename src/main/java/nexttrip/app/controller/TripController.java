package nexttrip.app.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import nexttrip.app.domain.entity.Trip;
import nexttrip.app.domain.payload.request.CreateTripRequest;
import nexttrip.app.domain.payload.request.UpdateTripRequest;
import nexttrip.app.repository.TripRepository;
import nexttrip.app.service.TripService;
import nexttrip.fw.web.rest.vm.BaseResponse;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@CrossOrigin(origins = "*")
@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1.0/trip")
public class TripController {

    private final TripService tripService;

    @PostMapping("")
    public BaseResponse<?> createTrip(@Valid @RequestBody CreateTripRequest request) {
        log.info("Request POST /trip: {}", request);
        var response = tripService.createTrip(request);
        log.info("Response POST /trip: {}", response);
        return BaseResponse.ok(response);
    }

    @GetMapping("/view")
    public BaseResponse<?> viewTrip() {
        log.info("Request GET /trip");
        var response = tripService.getListTrip();
        log.info("Response GET /trip: {}", response);
        return BaseResponse.ok(response);
    }

    @GetMapping("/home_view")
    public BaseResponse<?> viewHomeTrip() {
        log.info("Request GET /trip");
        var response = tripService.getHomeTrip();
        log.info("Response GET /trip: {}", response);
        return BaseResponse.ok(response);
    }

    @GetMapping("/detail/{id}")
    public BaseResponse<?> getTripDetail(@PathVariable Integer id) {
        log.info("Request GET /trip/detail/{}", id);
        var response = tripService.getTripDetail(id);
        log.info("Response GET /trip/detail/{}", response);
        return BaseResponse.ok(response);
    }

    @PutMapping("/{tripId}")
    public BaseResponse<?> updateTrip(@PathVariable Integer tripId,  @RequestBody UpdateTripRequest request) {
        log.info("Request GET /trip/detail/{}", tripId);
        var response = tripService.updateTrip(tripId, request);
        log.info("Response GET /trip/detail/{}", response);
        return BaseResponse.ok(response);}

    @DeleteMapping("/{tripId}")
    public BaseResponse<?> deleteTrip(@PathVariable Integer tripId) {
        log.info("Request GET /trip/detail/{}", tripId);
        var response = tripService.deleteTrip(tripId);
        log.info("Response GET /trip/detail/{}", response);
        return BaseResponse.ok(response);
    }


}
