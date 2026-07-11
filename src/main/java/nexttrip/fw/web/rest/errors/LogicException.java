package nexttrip.fw.web.rest.errors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class LogicException extends RuntimeException {
    public LogicException(String exception) {
        super(exception);
    }
}
