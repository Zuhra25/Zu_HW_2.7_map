package pro.sky.ZuHW27map.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.SEE_OTHER)
public class BadParamsException extends RuntimeException {
    public BadParamsException(String s) {
    }
}

