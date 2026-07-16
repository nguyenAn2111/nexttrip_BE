package nexttrip.app.domain.payload.request;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Data
public class CreateTripRequest {
    private  byte[] image;
    private String title;
    private String code;
    private String description;
    private LocalDate start_date;
    private LocalDate end_date;
    private String destination;
}
