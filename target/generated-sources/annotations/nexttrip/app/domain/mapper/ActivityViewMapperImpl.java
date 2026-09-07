package nexttrip.app.domain.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import nexttrip.app.domain.dto.ActivtityViewDto;
import nexttrip.app.domain.entity.Activity;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-08-26T17:32:30+0700",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.19 (Ubuntu)"
)
@Component
public class ActivityViewMapperImpl implements ActivityViewMapper {

    @Override
    public Activity toEntity(ActivtityViewDto dto) {
        if ( dto == null ) {
            return null;
        }

        Activity activity = new Activity();

        activity.setActivityId( dto.getActivityId() );
        activity.setItineraryId( dto.getItineraryId() );
        activity.setName( dto.getName() );
        activity.setLocation( dto.getLocation() );
        activity.setStartTime( dto.getStartTime() );
        activity.setEndTime( dto.getEndTime() );
        activity.setNote( dto.getNote() );

        return activity;
    }

    @Override
    public List<Activity> toEntity(List<ActivtityViewDto> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<Activity> list = new ArrayList<Activity>( dtoList.size() );
        for ( ActivtityViewDto activtityViewDto : dtoList ) {
            list.add( toEntity( activtityViewDto ) );
        }

        return list;
    }

    @Override
    public void partialUpdate(Activity entity, ActivtityViewDto dto) {
        if ( dto == null ) {
            return;
        }

        if ( dto.getActivityId() != null ) {
            entity.setActivityId( dto.getActivityId() );
        }
        if ( dto.getItineraryId() != null ) {
            entity.setItineraryId( dto.getItineraryId() );
        }
        if ( dto.getName() != null ) {
            entity.setName( dto.getName() );
        }
        if ( dto.getLocation() != null ) {
            entity.setLocation( dto.getLocation() );
        }
        if ( dto.getStartTime() != null ) {
            entity.setStartTime( dto.getStartTime() );
        }
        if ( dto.getEndTime() != null ) {
            entity.setEndTime( dto.getEndTime() );
        }
        if ( dto.getNote() != null ) {
            entity.setNote( dto.getNote() );
        }
    }

    @Override
    public ActivtityViewDto toDto(Activity activity) {
        if ( activity == null ) {
            return null;
        }

        ActivtityViewDto activtityViewDto = new ActivtityViewDto();

        activtityViewDto.setActivityId( activity.getActivityId() );
        activtityViewDto.setItineraryId( activity.getItineraryId() );
        activtityViewDto.setName( activity.getName() );
        activtityViewDto.setLocation( activity.getLocation() );
        activtityViewDto.setStartTime( activity.getStartTime() );
        activtityViewDto.setEndTime( activity.getEndTime() );
        activtityViewDto.setNote( activity.getNote() );

        return activtityViewDto;
    }

    @Override
    public List<ActivtityViewDto> toDto(List<Activity> activities) {
        if ( activities == null ) {
            return null;
        }

        List<ActivtityViewDto> list = new ArrayList<ActivtityViewDto>( activities.size() );
        for ( Activity activity : activities ) {
            list.add( toDto( activity ) );
        }

        return list;
    }
}
