package nexttrip.app.domain.dto;

import lombok.Data;
import nexttrip.app.domain.entity.Itinerary;

import java.time.LocalDateTime;

@Data
public class ActivtityViewDto {

    private Integer activityId;
    private Itinerary itineraryId;
    private String name;
    private String Location;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String note;
}
