package nexttrip.app.domain.entity.AI;

import java.time.LocalDateTime;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(AI_Conservation.class)
public abstract class AI_Conservation_ {

	public static volatile SingularAttribute<AI_Conservation, Integer> trip_id;
	public static volatile SingularAttribute<AI_Conservation, Integer> conservation_id;
	public static volatile SingularAttribute<AI_Conservation, Integer> user_id;
	public static volatile SingularAttribute<AI_Conservation, LocalDateTime> created_at;
	public static volatile SingularAttribute<AI_Conservation, String> title;

	public static final String TRIP_ID = "trip_id";
	public static final String CONSERVATION_ID = "conservation_id";
	public static final String USER_ID = "user_id";
	public static final String CREATED_AT = "created_at";
	public static final String TITLE = "title";

}

