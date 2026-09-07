package nexttrip.app.domain.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import nexttrip.app.common.enums.TripStatus;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Trip.class)
public abstract class Trip_ {

	public static volatile SingularAttribute<Trip, byte[]> image;
	public static volatile SingularAttribute<Trip, String> code;
	public static volatile SingularAttribute<Trip, LocalDate> endDate;
	public static volatile SingularAttribute<Trip, String> destination;
	public static volatile SingularAttribute<Trip, String> description;
	public static volatile SingularAttribute<Trip, Integer> ownerId;
	public static volatile SingularAttribute<Trip, String> title;
	public static volatile SingularAttribute<Trip, LocalDateTime> createdAt;
	public static volatile SingularAttribute<Trip, Integer> numberMember;
	public static volatile SingularAttribute<Trip, Integer> id;
	public static volatile SingularAttribute<Trip, LocalDate> startDate;
	public static volatile SingularAttribute<Trip, TripStatus> status;
	public static volatile SingularAttribute<Trip, LocalDateTime> updatedAt;

	public static final String IMAGE = "image";
	public static final String CODE = "code";
	public static final String END_DATE = "endDate";
	public static final String DESTINATION = "destination";
	public static final String DESCRIPTION = "description";
	public static final String OWNER_ID = "ownerId";
	public static final String TITLE = "title";
	public static final String CREATED_AT = "createdAt";
	public static final String NUMBER_MEMBER = "numberMember";
	public static final String ID = "id";
	public static final String START_DATE = "startDate";
	public static final String STATUS = "status";
	public static final String UPDATED_AT = "updatedAt";

}

