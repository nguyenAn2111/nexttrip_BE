package nexttrip.app.domain.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "work")
public class Work {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "work_id")
    private Integer work_id;

    @Column(name = "trip_id")
    private Integer trip_id;

    @Column(name = "detail")
    private String detail;

    @Column(name = "piority")
    private Integer piority;
}
