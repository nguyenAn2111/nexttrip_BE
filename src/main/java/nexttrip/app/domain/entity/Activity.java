package nexttrip.app.domain.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "activity")

public class Activity {

    @Id
    @Column(name = "activity_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer activityId;

//    @Column(name = "itinerary_id")
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "itinerary_id")
    private Itinerary itineraryId;

    @Column(name = "name")
    private String name;

    @Column(name= "location")
    private String location;

    @Column(name = "start_time")
    private LocalDateTime startTime;

    @Column(name = "end_time")
    private LocalDateTime endTime;

    @Column(name = "note")
    private String note;

    @Column(name = "order_index")
    private Integer order_index;

    @Column(name = "created_at")
    private LocalDateTime created_at;

    @Column(name = "updated_at")
    private LocalDateTime updated_at;

}
