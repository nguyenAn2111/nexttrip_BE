package nexttrip.app.repository;

import nexttrip.app.domain.entity.Activity;
import nexttrip.app.domain.entity.Itinerary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActivityRepository extends JpaRepository<Activity, Integer>, JpaSpecificationExecutor<Activity> {

    List<Activity> findByItineraryId_ItineraryIdOrderByStartTimeAsc(Integer itineraryId);

}
