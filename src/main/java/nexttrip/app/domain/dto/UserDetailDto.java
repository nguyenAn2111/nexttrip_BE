package nexttrip.app.domain.dto;

import lombok.Data;

import java.util.Date;

@Data
public class UserDetailDto {
    private Integer id;
    private String username;
    private String fullName;
    private String email;
    private String phone;
    private String avatar;
    private Date createdAt;
}
