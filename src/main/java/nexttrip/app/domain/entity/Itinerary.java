package nexttrip.app.domain.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@Table(name = "itinerary")
public class Itinerary {

    @Id
    @Column(name = "itinerary_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer itineraryId;

//    @Column(name = "trip_id")
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "trip_id")
    private Trip tripId;

    @Column(name = "day_number")
    private Integer dayNumber;

    @Column(name = "date")
    private LocalDate date;

    @Column(name= "title")
    private String title;

}
