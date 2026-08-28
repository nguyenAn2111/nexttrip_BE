package nexttrip.app.controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import nexttrip.app.domain.payload.request.InviteMemberRequest;
import nexttrip.app.service.CompanionService;
import nexttrip.fw.web.rest.vm.BaseResponse;
import org.springframework.web.bind.annotation.*;

@Slf4j
@CrossOrigin(origins = "*")
@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1.0/companion")
@SecurityRequirement(name = "Bearer Authentication")

public class CompanionController {
    private final CompanionService companionService;

    @GetMapping("/list_view")
    public BaseResponse<?>  getListTripByOwner(){
        log.info("Request GET /trip");
        var response = companionService.getListTripByOwner();
        log.info("Response GET /trip: {}", response);
        return BaseResponse.ok(response);
    }

    @PostMapping("/{tripId}/invite")
    public BaseResponse inviteMember(@PathVariable Integer tripId, @RequestBody InviteMemberRequest request){
        log.info("Request POST /invite member");
        var response = companionService.inviteMember(tripId, request);
        log.info("Response POST /invite member: {}", response);
        return BaseResponse.ok(response);
    }

    @GetMapping("/invite")
    public BaseResponse getInvitingTrip(@RequestParam Integer userId) {
        log.info("Request GET /invite");
        return BaseResponse.ok(
                companionService.getInvitingTrip(userId)
        );
    }




}
