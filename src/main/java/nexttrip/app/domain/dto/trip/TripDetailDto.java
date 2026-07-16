package nexttrip.app.domain.dto.trip;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class TripDetailDto {
    private Integer id;
    private String title;
    private String destination;
    private LocalDate startDate;
    private LocalDate endDate;
    private Integer numberMember;
    private String description;
    private String code;
}
