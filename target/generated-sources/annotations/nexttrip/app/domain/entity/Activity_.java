package nexttrip.app.domain.entity;

import java.time.LocalDateTime;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Activity.class)
public abstract class Activity_ {

	public static volatile SingularAttribute<Activity, Integer> activityId;
	public static volatile SingularAttribute<Activity, String> note;
	public static volatile SingularAttribute<Activity, LocalDateTime> updated_at;
	public static volatile SingularAttribute<Activity, Itinerary> itineraryId;
	public static volatile SingularAttribute<Activity, String> name;
	public static volatile SingularAttribute<Activity, LocalDateTime> created_at;
	public static volatile SingularAttribute<Activity, String> location;
	public static volatile SingularAttribute<Activity, LocalDateTime> startTime;
	public static volatile SingularAttribute<Activity, LocalDateTime> endTime;
	public static volatile SingularAttribute<Activity, Integer> order_index;

	public static final String ACTIVITY_ID = "activityId";
	public static final String NOTE = "note";
	public static final String UPDATED_AT = "updated_at";
	public static final String ITINERARY_ID = "itineraryId";
	public static final String NAME = "name";
	public static final String CREATED_AT = "created_at";
	public static final String LOCATION = "location";
	public static final String START_TIME = "startTime";
	public static final String END_TIME = "endTime";
	public static final String ORDER_INDEX = "order_index";

}

