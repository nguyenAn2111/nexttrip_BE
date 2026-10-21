package nexttrip.app.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import nexttrip.app.domain.entity.User;
import nexttrip.app.domain.payload.request.LoginRequest;
import nexttrip.app.domain.payload.request.RefreshTokenRequest;
import nexttrip.app.domain.payload.response.TokenResponse;
import nexttrip.app.repository.UserRepository;
import nexttrip.app.service.AuthService;
import nexttrip.app.service.UserService;
import nexttrip.fw.security.jwt.TokenProvider;
import nexttrip.fw.utils.SecurityUtils;
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


        Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);

        String token = tokenProvider.createToken(authentication);
        String refreshToken = tokenProvider.createRefreshToken(authentication);

//        user.setLastLoginAt(newDate());
//        this.userRepository.save(user);

        return new TokenResponse(token, refreshToken);
    }

    @Override
    public void logout (){
        String username = SecurityUtils.getCurrentUsernameLogin();
        if (username.equals("anonymous")) {
            tokenProvider.removeToken(username);
        }
    }

    @Override
    public TokenResponse refreshToken(RefreshTokenRequest request){
        String refreshToken = request.getRefreshToken();
        String token = tokenProvider.refreshToken(refreshToken);
        return new TokenResponse(token, refreshToken);
    }
}
