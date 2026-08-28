package nexttrip.app.controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import nexttrip.app.domain.payload.request.CreateActivityRequest;
import nexttrip.app.domain.payload.request.CreateItineraryRequest;
import nexttrip.app.domain.payload.request.CreateTripRequest;
import nexttrip.app.service.ItineraryService;
import nexttrip.fw.web.rest.vm.BaseResponse;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@CrossOrigin(origins = "*")
@RestController
@RequiredArgsConstructor
@SecurityRequirement(name = "Bearer Authentication")
@RequestMapping("api/v1.0/itinerary")
public class ItineraryController {

    private final ItineraryService itineraryService;

    @PostMapping("")
    public BaseResponse<?> createItinerary(@Valid @RequestBody CreateItineraryRequest request, @RequestParam Integer tripId) {
        log.info("Request POST /trip: {}", request, tripId);
        var response = itineraryService.createItinerary(request, tripId);
        log.info("Response POST /trip: {}", response, tripId);
        return BaseResponse.ok(response);
    }

    @PostMapping("/activity")
    public BaseResponse<?> createActivity(@Valid @RequestBody CreateActivityRequest request, @RequestParam Integer itineraryId) {
        log.info("Request POST /trip: {}", request, itineraryId);
        var response = itineraryService.createActivity(request, itineraryId);
        log.info("Response POST /trip: {}", response, itineraryId);
        return BaseResponse.ok(response);
    }

    @GetMapping("/list_view")
    public BaseResponse<?> getListItinerary(@RequestParam Integer tripId) {
        log.info("Request GET /trip: {}", tripId);
        var response = itineraryService.getListItinerary(tripId);
        log.info("Response GET /trip: {}", response);
        return BaseResponse.ok(response);
    }

    @GetMapping("/activity/list_view")
    public BaseResponse<?> getListActivity(@RequestParam Integer itineraryId) {
        log.info("Request GET /trip: {}", itineraryId);
        var response = itineraryService.getListActivity(itineraryId);
        log.info("Response GET /trip: {}", response);
        return BaseResponse.ok(response);
    }
}
