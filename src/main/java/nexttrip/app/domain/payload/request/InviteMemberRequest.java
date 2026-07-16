package nexttrip.app.domain.payload.request;

import lombok.Data;

@Data
public class InviteMemberRequest {

    private Integer userId;

    private String phoneNumber;
}
