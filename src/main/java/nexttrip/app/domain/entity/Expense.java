package nexttrip.app.domain.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import nexttrip.app.common.enums.FinanceType;

import javax.naming.Name;
import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "expense")
public class Expense {

    @Id
    @Column(name = "expense_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer expenseId;


    @Column(name = "trip_id")
    private Integer tripId;

    @Column(name = "finance_id")
    private Integer financeId;

    @Column(name = "content")
    private String content;

    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    private FinanceType type;

    @Column(name = "cost")
    private BigDecimal cost;

    @Column(name = "payer")
    private String payer;

    @Column(name = "note")
    private String note;

//    @Column(name = "total_pay")
//    private BigDecimal totalPay;

    @Column(name = "updated_at")
    private LocalDateTime updated_at;

    @Column(name = "created_at")
    private LocalDateTime created_at;

}
