package nexttrip.app.domain.payload.request;

import lombok.Data;
import nexttrip.app.common.enums.TripStatus;

import java.time.LocalDate;

@Data
public class UpdateTripRequest {

    private String title;
    private String code;
    private String description;
    private LocalDate start_date;
    private LocalDate end_date;
    private String destination;
    private TripStatus trip_status;
}
