package nexttrip.app.domain.payload.request;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UpdateUserRequest {
    private String fullName;
    private String email;
    private String phone;
    private String avatar;
}
