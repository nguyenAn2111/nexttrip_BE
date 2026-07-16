package nexttrip.app.common.enums;

import lombok.Getter;
import org.springframework.web.bind.annotation.GetMapping;

@Getter
public enum MemberRole {

    LEADER("LEADER"),
    VICE("VICE"),
    MEMBER("MEMBER"),
    ACCOUNTANT("ACCOUNTANT");


    private final String value;
    MemberRole(String value) {this.value = value;}
}
