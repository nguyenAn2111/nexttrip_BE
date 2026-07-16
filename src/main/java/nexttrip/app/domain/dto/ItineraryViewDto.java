package nexttrip.app.domain.dto;

import lombok.Data;
import nexttrip.app.domain.entity.Trip;

import java.time.LocalDate;

@Data
public class ItineraryViewDto {

    private Trip tripId;
    private String title;
    private LocalDate date;
    private Integer dayNumber;
    private Integer itineraryId;
}
