package nexttrip.fw.web.rest.errors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.SERVICE_UNAVAILABLE)
public class ClientServerException extends RuntimeException {
    public ClientServerException(String exception) {
        super(exception);
    }
}
