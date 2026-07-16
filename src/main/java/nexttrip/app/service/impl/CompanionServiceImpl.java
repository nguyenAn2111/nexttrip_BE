package nexttrip.app.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import nexttrip.app.common.enums.MemberRole;
import nexttrip.app.common.enums.MemberStatus;
import nexttrip.app.domain.dto.trip.TripViewDto;
import nexttrip.app.domain.entity.Trip;
import nexttrip.app.domain.entity.TripMember;
import nexttrip.app.domain.entity.User;
import nexttrip.app.domain.mapper.trip.TripViewMapper;
import nexttrip.app.domain.payload.request.InviteMemberRequest;
import nexttrip.app.repository.TripMemberRepository;
import nexttrip.app.repository.TripRepository;
import nexttrip.app.repository.UserRepository;
import nexttrip.app.service.CompanionService;
import nexttrip.app.service.TripService;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class CompanionServiceImpl implements CompanionService {

    private final TripRepository tripRepository;
    private final TripViewMapper tripViewMapper;
    private final UserRepository userRepository;
    private final TripMemberRepository tripMemberRepository;

    @Override
    public void updateNumberMember(Integer tripId) {

        Integer count = tripMemberRepository
                .countByTripId_IdAndStatus(
                        tripId,
                        MemberStatus.ACCEPTED
                );

        Trip trip = tripRepository.findById(tripId)
                .orElseThrow(() ->
                        new RuntimeException("Trip not found")
                );

        trip.setNumberMember(count);

        tripRepository.save(trip);
    }

    @Override
    public List<TripViewDto> getListTripByOwner(){
        List<Trip> trips = tripRepository.findByOwnerId(1);
        return this.tripViewMapper.toDto(trips);
    }

    @Override
    public Integer inviteMember(
            Integer tripId,
            InviteMemberRequest request
    ) {

        Trip trip = tripRepository.findById(tripId)
                .orElseThrow(() ->
                        new RuntimeException("Trip not found")
                );


        User user;


        if (request.getUserId() != null) {

            user = userRepository.findById(request.getUserId())
                    .orElseThrow(() ->
                            new RuntimeException("User not found")
                    );

        }

        // tìm user bằng số điện thoại
        else if (request.getPhoneNumber() != null) {

            user = userRepository.findByPhone(
                    request.getPhoneNumber()
            ).orElseThrow(() ->
                    new RuntimeException("User not found")
            );

        }

        else {
            throw new RuntimeException(
                    "Need userId or phoneNumber"
            );
        }


        TripMember member = new TripMember();

        member.setTripId(trip);
        member.setUserId(user);

        member.setStatus(MemberStatus.INVITING);

        member.setRole(MemberRole.MEMBER);


        tripMemberRepository.save(member);

        updateNumberMember(trip.getId());


        return member.getId();
    }

    @Override
    public List<TripViewDto> getInvitingTrip(Integer userId) {

        List<Trip> trips = tripRepository.findInvitingTripsByUserId(
                userId,
                MemberStatus.INVITING
        );

        return tripViewMapper.toDto(trips);
    }
}
