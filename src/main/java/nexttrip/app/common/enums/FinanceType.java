package nexttrip.app.common.enums;

import lombok.Getter;

@Getter
public enum FinanceType {

    STAY("STAY"),
    MOVE("MOVE"),
    EAT("EAT"),
    ACTIVITY("ACTIVITY"),
    OTHER("OTHER");

    private final String value;
    FinanceType(String value) {this.value = value;}
}
