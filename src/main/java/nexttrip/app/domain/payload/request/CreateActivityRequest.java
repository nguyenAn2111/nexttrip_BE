package nexttrip.app.domain.payload.request;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class CreateActivityRequest {

    private String name;
    private String Location;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String note;
}
