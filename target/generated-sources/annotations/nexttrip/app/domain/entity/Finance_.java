package nexttrip.app.domain.entity;

import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Finance.class)
public abstract class Finance_ {

	public static volatile SingularAttribute<Finance, Integer> tripMemberId;
	public static volatile SingularAttribute<Finance, BigDecimal> stayPay;
	public static volatile SingularAttribute<Finance, BigDecimal> eatPay;
	public static volatile SingularAttribute<Finance, BigDecimal> movePay;
	public static volatile SingularAttribute<Finance, BigDecimal> actPay;
	public static volatile SingularAttribute<Finance, BigDecimal> otherPay;
	public static volatile SingularAttribute<Finance, Integer> financeId;
	public static volatile SingularAttribute<Finance, Integer> tripId;
	public static volatile SingularAttribute<Finance, BigDecimal> totalRevenue;
	public static volatile SingularAttribute<Finance, BigDecimal> planTotal;

	public static final String TRIP_MEMBER_ID = "tripMemberId";
	public static final String STAY_PAY = "stayPay";
	public static final String EAT_PAY = "eatPay";
	public static final String MOVE_PAY = "movePay";
	public static final String ACT_PAY = "actPay";
	public static final String OTHER_PAY = "otherPay";
	public static final String FINANCE_ID = "financeId";
	public static final String TRIP_ID = "tripId";
	public static final String TOTAL_REVENUE = "totalRevenue";
	public static final String PLAN_TOTAL = "planTotal";

}

