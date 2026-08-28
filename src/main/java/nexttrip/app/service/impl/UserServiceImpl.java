package nexttrip.app.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import nexttrip.app.common.enums.SysError;
import nexttrip.app.domain.dto.UserDetailDto;
import nexttrip.app.domain.entity.User;
import nexttrip.app.domain.payload.request.CreateUserRequest;
import nexttrip.app.domain.payload.response.CreateUserResponse;
import nexttrip.app.repository.UserRepository;
import nexttrip.app.service.UserService;
import nexttrip.fw.security.jwt.UserJwtPayload;
import nexttrip.fw.web.rest.errors.BadRequestException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public User getUser(String username){
        User user = this.userRepository.findByUsername(username)
                .orElseThrow(() -> new BadRequestException(SysError.USER_NOT_FOUND.name()));
//        if (validateUser(user.getStatus()))
        return user;
    }

    @Override
    public CreateUserResponse createUser(CreateUserRequest request){
        User newUser = new User();
        newUser.setUsername(request.getUsername());
        newUser.setEmail(request.getEmail());
        newUser.setPhone(request.getPhone());
        newUser.setFullName(request.getFullName());
        newUser.setCreatedAt(LocalDateTime.now());

        String password = request.getPassword();
        String passwordEncoded = passwordEncoder.encode(password);
        newUser.setPassword(passwordEncoded);
        newUser = this.userRepository.save(newUser);

        return new CreateUserResponse(newUser.getId(), newUser.getUsername(), newUser.getEmail());

    }

//    @Override
//    public UserDetailDto getUserDetail(Integer id){
//
//    }

}
