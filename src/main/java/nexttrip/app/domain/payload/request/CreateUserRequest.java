package nexttrip.app.domain.payload.request;

import lombok.Data;

@Data
public class CreateUserRequest {
    private String username;
    private String fullName;
    private String password;
    private String email;
    private String phone;
}
