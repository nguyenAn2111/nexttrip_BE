package nexttrip.app.common.enums;

import lombok.Getter;

@Getter
public enum MemberStatus {

    INVITING("INVITING"),
    ACCEPTED("ACCEPTED"),
    REJECTED("REJECTED");

    private final String value;
    MemberStatus(String value) {this.value = value;}
}