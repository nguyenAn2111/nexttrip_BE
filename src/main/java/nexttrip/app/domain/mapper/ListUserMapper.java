package nexttrip.app.domain.mapper;

import nexttrip.app.domain.dto.ListUserDto;
import nexttrip.app.domain.entity.User;
import nexttrip.fw.mapper.EntityMapper;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ListUserMapper extends EntityMapper<ListUserDto, User> {
    ListUserDto toDto(User user);
    List<ListUserDto> toDto(List<User> users);
}
