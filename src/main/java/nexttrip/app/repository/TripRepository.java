package nexttrip.app.repository;

import feign.Param;
import nexttrip.app.common.enums.MemberStatus;
import nexttrip.app.common.enums.TripStatus;
import nexttrip.app.domain.dto.trip.TripViewDto;
import nexttrip.app.domain.entity.Trip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TripRepository extends JpaRepository<Trip, Integer>, JpaSpecificationExecutor<Trip> {

    List<Trip> findByStatusIn(List<TripStatus> statuses);
    List<Trip> findByOwnerId(Integer ownerId);

    @Query("""
    SELECT t
    FROM Trip t
    JOIN TripMember tm ON tm.tripId.id = t.id
    WHERE t.ownerId <> :userId
    AND tm.userId.id = :userId
    AND tm.status = :status
""")
    List<Trip> findInvitingTripsByUserId(
            @Param("userId") Integer userId,
            @Param("status") MemberStatus status
    );
}
