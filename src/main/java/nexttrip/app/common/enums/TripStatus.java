package nexttrip.app.common.enums;

import lombok.Getter;

@Getter
public enum TripStatus {

    PLANNING("PLANNING"),
    PROCESSING("PROCESSING"),
    END("END");

    private final String value;
    TripStatus(String value) {this.value = value;}
}
