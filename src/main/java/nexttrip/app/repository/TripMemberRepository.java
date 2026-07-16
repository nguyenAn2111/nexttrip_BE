package nexttrip.app.repository;

import nexttrip.app.common.enums.MemberStatus;
import nexttrip.app.domain.entity.Trip;
import nexttrip.app.domain.entity.TripMember;
import nexttrip.app.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface TripMemberRepository extends JpaRepository<TripMember, Integer> ,JpaSpecificationExecutor<TripMember>{

    boolean existsByTripIdAndUserId(
            Trip trip,
            User user
    );

    Integer countByTripId_IdAndStatus(
            Integer tripId,
            MemberStatus status
    );

}
