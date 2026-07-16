package nexttrip.app.domain.entity;

import lombok.Getter;
import lombok.Setter;
import nexttrip.app.common.enums.MemberRole;
import nexttrip.app.common.enums.MemberStatus;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "trip_member")
public class TripMember {
    @Id
    @Column(name = "trip_member_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "trip_id")
    private Trip tripId;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User userId;

    @Enumerated(EnumType.STRING)
    @Column(name ="role")
    private MemberRole role;

    @Enumerated(EnumType.STRING)
    @Column(name="status")
    private MemberStatus status;
}
