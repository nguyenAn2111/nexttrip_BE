package nexttrip.app.domain.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
@Table(name = "finance")
public class Finance {
    @Id
    @Column(name = "finance_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer financeId;

    @Column(name = "trip_id")
    private Integer tripId;

    @Column(name = "trip_member_id")
    private Integer tripMemberId;

    @Column(name = "plan_stay_pay")
    private BigDecimal stayPay;

    @Column(name = "plan_move_pay")
    private BigDecimal movePay;

    @Column(name = "plan_eat_pay")
    private BigDecimal eatPay;

    @Column(name = "plan_act_pay")
    private BigDecimal actPay;

    @Column(name = "plan_other_pay")
    private BigDecimal otherPay;

    @Column(name = "plan_total")
    private BigDecimal planTotal;

    @Column(name = "total_revenue")
    private BigDecimal totalRevenue;

}
