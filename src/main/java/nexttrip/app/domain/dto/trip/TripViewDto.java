package nexttrip.app.domain.dto.trip;

import lombok.Data;
import nexttrip.app.common.enums.TripStatus;
import org.apache.poi.hpsf.Decimal;

import java.time.LocalDate;

@Data
public class TripViewDto {
    private Integer trip_id;
    private  byte[] image;
    private String title;
//    private String code;
//    private String description;
    private LocalDate start_date;
    private LocalDate end_date;
    private String destination;
    private TripStatus status;
    private Integer number_member;
    private String code;
}
