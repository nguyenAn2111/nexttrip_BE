package nexttrip.app.domain.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import nexttrip.app.common.enums.MemberRole;
import nexttrip.app.common.enums.MemberStatus;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(TripMember.class)
public abstract class TripMember_ {

	public static volatile SingularAttribute<TripMember, MemberRole> role;
	public static volatile SingularAttribute<TripMember, Trip> tripId;
	public static volatile SingularAttribute<TripMember, Integer> id;
	public static volatile SingularAttribute<TripMember, User> userId;
	public static volatile SingularAttribute<TripMember, MemberStatus> status;

	public static final String ROLE = "role";
	public static final String TRIP_ID = "tripId";
	public static final String ID = "id";
	public static final String USER_ID = "userId";
	public static final String STATUS = "status";

}

