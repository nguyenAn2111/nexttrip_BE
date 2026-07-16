package nexttrip.app.domain.payload.request;

import lombok.Data;

import java.time.LocalDate;

@Data
public class CreateItineraryRequest {

    private String title;
    private LocalDate date;
    private Integer dayNumber;
}
