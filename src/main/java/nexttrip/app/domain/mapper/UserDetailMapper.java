package nexttrip.app.domain.mapper;

import nexttrip.app.domain.dto.UserDetailDto;
import nexttrip.app.domain.entity.User;
import nexttrip.fw.mapper.EntityMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserDetailMapper extends EntityMapper<UserDetailDto, User> {
    UserDetailDto toDto(User user);
}
