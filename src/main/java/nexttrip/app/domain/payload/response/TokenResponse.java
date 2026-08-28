package nexttrip.app.domain.payload.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@AllArgsConstructor
@Data
public class TokenResponse {

    private String token;
    private String refreshToken;
}
