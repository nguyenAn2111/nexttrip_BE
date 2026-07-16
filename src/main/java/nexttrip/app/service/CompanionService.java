package nexttrip.app.service;

import nexttrip.app.domain.dto.trip.TripViewDto;
import nexttrip.app.domain.payload.request.InviteMemberRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CompanionService {

    void updateNumberMember(Integer tripId);


    List<TripViewDto> getListTripByOwner();

    Integer inviteMember(Integer tripId, InviteMemberRequest request);

    List<TripViewDto> getInvitingTrip(Integer userId);
}
