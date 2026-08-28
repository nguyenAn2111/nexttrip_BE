package nexttrip.app.service;

import nexttrip.app.domain.payload.request.LoginRequest;
import nexttrip.app.domain.payload.response.TokenResponse;
import org.springframework.stereotype.Service;

@Service
public interface AuthService {

    TokenResponse login(LoginRequest request);
}
