package nexttrip.app.domain.entity.AI;

import lombok.Getter;
import lombok.Setter;

import javax.naming.Name;
import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "AI_conservation")
public class AI_Conservation {
    @Id
    @Column(name = "conservation_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer conservation_id;

    @Column(name = "user_id")
    private Integer user_id;

    @Column(name = "trip_id")
    private Integer trip_id;

    @Column(name = "title")
    private String title;

    @Column(name = "created_at")
    private LocalDateTime created_at;
}
