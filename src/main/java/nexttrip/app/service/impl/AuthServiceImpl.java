package nexttrip.app.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import nexttrip.app.domain.entity.User;
import nexttrip.app.domain.payload.request.LoginRequest;
import nexttrip.app.domain.payload.response.TokenResponse;
import nexttrip.app.repository.UserRepository;
import nexttrip.app.service.AuthService;
import nexttrip.app.service.UserService;
import nexttrip.fw.security.jwt.TokenProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.token.TokenService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final UserService userService;
    private final AuthenticationManagerBuilder authenticationManagerBuilder;
    private final TokenProvider tokenProvider;


    @Override
    public TokenResponse login (LoginRequest request) {

        String username = request.getUsername().toLowerCase();
//        User user = this.userService.getUser(username);

        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(username, request.getPassword());
        log.info("=== LOGIN START ===");
        log.info("authenticationToken={}", authenticationToken);

        Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);
        log.info("Authenticated: {}", authentication.isAuthenticated());
        log.info("Principal: {}", authentication.getPrincipal());

        String token = tokenProvider.createToken(authentication);
        log.info("token: {}", token);
        String refreshToken = tokenProvider.createRefreshToken(authentication);
        log.info("refreshToken: {}", refreshToken);

//        user.setLastLoginAt(newmDate());
//        this.userRepository.save(user);

        return new TokenResponse(token, refreshToken);
    }
}
