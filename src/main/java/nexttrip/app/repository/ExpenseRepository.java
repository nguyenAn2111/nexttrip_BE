package nexttrip.app.repository;

import feign.Param;
import nexttrip.app.domain.entity.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Integer>, JpaSpecificationExecutor<Expense> {
    List<Expense> findByTripId(Integer tripId);

    @Query("SELECT COALESCE(SUM(e.cost), 0) FROM Expense e WHERE e.tripId = :tripId")
    BigDecimal getTotalExpense(@Param("tripId") Integer tripId);
}
