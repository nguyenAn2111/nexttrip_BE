package nexttrip.app.controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import nexttrip.app.domain.payload.request.LoginRequest;
import nexttrip.app.domain.payload.response.TokenResponse;
import nexttrip.app.service.AuthService;
import org.springframework.security.core.token.TokenService;
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
        log.info("Login request: {}", request);
        var response = authService.login(request);
        log.info("Login response: {}", response);
        return response;
    }
}
