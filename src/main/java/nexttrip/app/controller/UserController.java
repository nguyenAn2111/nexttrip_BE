package nexttrip.app.controller;

import com.fasterxml.jackson.databind.ser.Serializers;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import nexttrip.app.domain.dto.ListUserDto;
import nexttrip.app.domain.dto.UserDetailDto;
import nexttrip.app.domain.payload.request.CreateUserRequest;
import nexttrip.app.domain.payload.request.UpdateUserRequest;
import nexttrip.app.domain.payload.response.CreateUserResponse;
import nexttrip.app.service.UserService;
import nexttrip.fw.web.rest.vm.BaseResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @SecurityRequirement(name = "Bearer Authentication")
    @GetMapping("/current_detail")
    public BaseResponse<UserDetailDto> getUserDetail(){
        log.info("Request GET /current_detail: ");
        var response = userService.getUserDetail();
        log.info("Response GET /current_detail: {}", response);
        return BaseResponse.ok(response);
    }

//    @SecurityRequirement(name = "Bearer Authentication")
    @GetMapping("/list_all")
    public BaseResponse<List<ListUserDto>> getAllUsers(){
        log.info("Request GET /list_all: ");
        var response = userService.getAllUsers();
        log.info("Response GET /list_all: {}", response);
        return BaseResponse.ok(response);
    }

    @SecurityRequirement(name = "Bearer Authentication")
    @PatchMapping("")
    public BaseResponse<UserDetailDto> updateUser(@RequestBody UpdateUserRequest request){
        log.info("Update user request: {}", request);
        var response = userService.updateUser(request);
        log.info("Update user response: {}", response);
        return BaseResponse.ok(response);
    }

}
