package nexttrip.app.service;

import nexttrip.app.domain.dto.ListUserDto;
import nexttrip.app.domain.dto.UserDetailDto;
import nexttrip.app.domain.entity.User;
import nexttrip.app.domain.payload.request.CreateUserRequest;
import nexttrip.app.domain.payload.request.UpdateUserRequest;
import nexttrip.app.domain.payload.response.CreateUserResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    User getUser(String username);

    List<ListUserDto> getAllUsers();

    CreateUserResponse createUser(CreateUserRequest request);

    UserDetailDto getUserDetail();

    UserDetailDto updateUser(UpdateUserRequest request);
}
