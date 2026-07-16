package nexttrip.app.domain.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;
import org.w3c.dom.Text;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name="destination")
public class Destination {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "destination_id")
    private Integer destination_id;

    @Column(name = "name")
    private String name;

    @Column(name = "city")
    private String city;

    @Column(name="country")
    private String country;

    @Column(name = "desciption")
    private String desciption;

    @Column(name ="thumbnail")
    private String thumbnail;
}
