package nexttrip.app.service;

import nexttrip.app.domain.entity.User;
import nexttrip.app.domain.payload.request.CreateUserRequest;
import nexttrip.app.domain.payload.response.CreateUserResponse;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    User getUser(String username);

    CreateUserResponse createUser(CreateUserRequest request);
}
