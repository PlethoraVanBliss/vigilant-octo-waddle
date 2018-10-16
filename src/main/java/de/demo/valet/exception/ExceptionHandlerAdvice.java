package de.demo.valet.exception;

import com.google.common.collect.ImmutableMap;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Map;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@Slf4j
@ControllerAdvice
public class ExceptionHandlerAdvice {

    private static final String MSG  = "message";
    private static final String STATUS  = "status";

    @ResponseBody
    @ResponseStatus(NOT_FOUND)
    @ExceptionHandler(NotFoundException.class)
    public Map handleNotFound(NotFoundException e) {
        log.warn(
                "Error message [{}]",
                e.getMessage());
        return errorMessage(BAD_REQUEST.value(), e.getMessage());
    }

    private static Map errorMessage(int httpStatus, String message){
        return ImmutableMap.of(STATUS, httpStatus, MSG, message);
    }
}
