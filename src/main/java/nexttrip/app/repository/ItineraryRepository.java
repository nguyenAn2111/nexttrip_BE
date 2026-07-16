package nexttrip.app.repository;

import nexttrip.app.domain.entity.Itinerary;
import nexttrip.app.domain.entity.Trip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItineraryRepository extends JpaRepository<Itinerary, Integer>, JpaSpecificationExecutor<Itinerary> {

    List<Itinerary> findByTripId_IdOrderByDayNumberAsc(Integer tripId);
}
