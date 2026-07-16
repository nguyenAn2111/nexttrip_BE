package nexttrip.app.repository;

import nexttrip.app.domain.dto.FinanceDetailDto;
import nexttrip.app.domain.entity.Finance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface FinanceRepository extends JpaRepository<Finance, Integer>, JpaSpecificationExecutor<Finance> {
    Finance findTopByTripIdOrderByFinanceIdDesc(Integer tripId);
}
