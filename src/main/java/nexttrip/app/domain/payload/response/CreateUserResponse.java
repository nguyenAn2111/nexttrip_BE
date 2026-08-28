package nexttrip.app.domain.payload.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class CreateUserResponse {
    private Integer id;
    private String username;
    private String email;
}
