package nexttrip.app.domain.entity.AI;

import java.time.LocalDateTime;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(AI_Message.class)
public abstract class AI_Message_ {

	public static volatile SingularAttribute<AI_Message, String> role;
	public static volatile SingularAttribute<AI_Message, Integer> conservation_id;
	public static volatile SingularAttribute<AI_Message, LocalDateTime> created_at;
	public static volatile SingularAttribute<AI_Message, Integer> message_id;
	public static volatile SingularAttribute<AI_Message, String> content;

	public static final String ROLE = "role";
	public static final String CONSERVATION_ID = "conservation_id";
	public static final String CREATED_AT = "created_at";
	public static final String MESSAGE_ID = "message_id";
	public static final String CONTENT = "content";

}

