package nexttrip.app.domain.entity;

import java.time.LocalDateTime;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(User.class)
public abstract class User_ {

	public static volatile SingularAttribute<User, LocalDateTime> createdAt;
	public static volatile SingularAttribute<User, String> password;
	public static volatile SingularAttribute<User, String> phone;
	public static volatile SingularAttribute<User, String> fullName;
	public static volatile SingularAttribute<User, Integer> id;
	public static volatile SingularAttribute<User, String> avatar;
	public static volatile SingularAttribute<User, String> email;
	public static volatile SingularAttribute<User, String> username;
	public static volatile SingularAttribute<User, LocalDateTime> updatedAt;

	public static final String CREATED_AT = "createdAt";
	public static final String PASSWORD = "password";
	public static final String PHONE = "phone";
	public static final String FULL_NAME = "fullName";
	public static final String ID = "id";
	public static final String AVATAR = "avatar";
	public static final String EMAIL = "email";
	public static final String USERNAME = "username";
	public static final String UPDATED_AT = "updatedAt";

}

