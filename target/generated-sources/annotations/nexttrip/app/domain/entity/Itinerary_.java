package nexttrip.app.domain.entity;

import java.time.LocalDate;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Itinerary.class)
public abstract class Itinerary_ {

	public static volatile SingularAttribute<Itinerary, LocalDate> date;
	public static volatile SingularAttribute<Itinerary, Integer> itineraryId;
	public static volatile SingularAttribute<Itinerary, Integer> dayNumber;
	public static volatile SingularAttribute<Itinerary, Trip> tripId;
	public static volatile SingularAttribute<Itinerary, String> title;

	public static final String DATE = "date";
	public static final String ITINERARY_ID = "itineraryId";
	public static final String DAY_NUMBER = "dayNumber";
	public static final String TRIP_ID = "tripId";
	public static final String TITLE = "title";

}

