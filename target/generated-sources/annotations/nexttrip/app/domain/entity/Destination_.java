package nexttrip.app.domain.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Destination.class)
public abstract class Destination_ {

	public static volatile SingularAttribute<Destination, String> country;
	public static volatile SingularAttribute<Destination, String> desciption;
	public static volatile SingularAttribute<Destination, String> thumbnail;
	public static volatile SingularAttribute<Destination, String> city;
	public static volatile SingularAttribute<Destination, Integer> destination_id;
	public static volatile SingularAttribute<Destination, String> name;

	public static final String COUNTRY = "country";
	public static final String DESCIPTION = "desciption";
	public static final String THUMBNAIL = "thumbnail";
	public static final String CITY = "city";
	public static final String DESTINATION_ID = "destination_id";
	public static final String NAME = "name";

}

