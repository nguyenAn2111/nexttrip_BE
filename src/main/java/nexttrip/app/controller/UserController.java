package nexttrip.app.controller;

import com.fasterxml.jackson.databind.ser.Serializers;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import nexttrip.app.domain.payload.request.CreateUserRequest;
import nexttrip.app.domain.payload.response.CreateUserResponse;
import nexttrip.app.service.UserService;
import nexttrip.fw.web.rest.vm.BaseResponse;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@Slf4j
@CrossOrigin(origins = "*")
@RequestMapping("api/v1.0/user")

public class UserController {
    private final UserService userService;

    @PostMapping
    public BaseResponse<CreateUserResponse> createUser(@RequestBody CreateUserRequest request){
        log.info("Create user request: {}", request);
        var response = userService.createUser(request);
        log.info("Create user response: {}", response);
        return BaseResponse.ok(response);
    }
}
