package nexttrip.app.controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import nexttrip.app.domain.payload.request.LoginRequest;
import nexttrip.app.domain.payload.request.RefreshTokenRequest;
import nexttrip.app.domain.payload.response.TokenResponse;
import nexttrip.app.service.AuthService;
import nexttrip.fw.web.rest.vm.BaseResponse;
import org.springframework.web.bind.annotation.*;

@Slf4j
@CrossOrigin(origins = "*")
@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1.0/auth")
public class AuthController {
    private final AuthService authService;

    @PostMapping("/login")
    public TokenResponse login(@RequestBody LoginRequest request){
        log.info("Login username: {}", request.getUsername());
        var response = authService.login(request);
        log.info("Login response: {}", response);
        return response;
    }

    @SecurityRequirement(name = "Bearer Authentication")
    @PostMapping("/logout")
    public BaseResponse<?> logout(){
        log.info("Request POST /auth/logout");
        this.authService.logout();
        log.info("Response POST /auth/logout");
        return BaseResponse.ok();
    }

    @PostMapping("/refresh-token")
    public BaseResponse<?> refreshToken(@RequestBody RefreshTokenRequest request){
        log.info("Request POST /auth/refreshToken");
        var response = authService.refreshToken(request);
        log.info("Response POST /auth/refreshToken");
        return BaseResponse.ok(response);
    }

}
