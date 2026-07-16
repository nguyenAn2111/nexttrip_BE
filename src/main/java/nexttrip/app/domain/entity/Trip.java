package nexttrip.app.domain.entity;

import lombok.Getter;
import lombok.Setter;
import nexttrip.app.common.enums.TripStatus;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "trip")
public class Trip {
    @Id
    @Column(name = "trip_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "owner_id")
    private Integer ownerId;

    @Column(name = "destination")
    private String destination;

    @Column(name = "code")
    private String code;

    @Column(name="image")
    private byte[] image;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private TripStatus status;

    @Column(name = "number_member")
    private Integer numberMember;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
}
