package nexttrip.app.domain.entity.AI;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "AI_message")

public class AI_Message {

    @Id
    @Column(name = "message_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer message_id;

    @Column(name = "conservation_id")
    private Integer conservation_id;

    @Column(name = "role")
    private String role;

    @Column(name = "content")
    private String content;

    @Column(name = "created_at")
    private LocalDateTime created_at;
}
