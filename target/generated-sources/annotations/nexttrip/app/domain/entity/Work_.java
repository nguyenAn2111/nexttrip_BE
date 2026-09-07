package nexttrip.app.domain.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Work.class)
public abstract class Work_ {

	public static volatile SingularAttribute<Work, Integer> work_id;
	public static volatile SingularAttribute<Work, Integer> trip_id;
	public static volatile SingularAttribute<Work, Integer> piority;
	public static volatile SingularAttribute<Work, String> detail;

	public static final String WORK_ID = "work_id";
	public static final String TRIP_ID = "trip_id";
	public static final String PIORITY = "piority";
	public static final String DETAIL = "detail";

}

