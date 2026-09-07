package nexttrip.app.domain.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import nexttrip.app.common.enums.FinanceType;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Expense.class)
public abstract class Expense_ {

	public static volatile SingularAttribute<Expense, String> note;
	public static volatile SingularAttribute<Expense, BigDecimal> cost;
	public static volatile SingularAttribute<Expense, LocalDateTime> updated_at;
	public static volatile SingularAttribute<Expense, Integer> expenseId;
	public static volatile SingularAttribute<Expense, LocalDateTime> created_at;
	public static volatile SingularAttribute<Expense, Integer> tripId;
	public static volatile SingularAttribute<Expense, Integer> financeId;
	public static volatile SingularAttribute<Expense, FinanceType> type;
	public static volatile SingularAttribute<Expense, String> payer;
	public static volatile SingularAttribute<Expense, String> content;

	public static final String NOTE = "note";
	public static final String COST = "cost";
	public static final String UPDATED_AT = "updated_at";
	public static final String EXPENSE_ID = "expenseId";
	public static final String CREATED_AT = "created_at";
	public static final String TRIP_ID = "tripId";
	public static final String FINANCE_ID = "financeId";
	public static final String TYPE = "type";
	public static final String PAYER = "payer";
	public static final String CONTENT = "content";

}

