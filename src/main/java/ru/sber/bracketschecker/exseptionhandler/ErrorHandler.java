package ru.sber.bracketschecker.exseptionhandler;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.sber.bracketschecker.exception.JsonFieldException;

import java.util.Map;

@Slf4j
@RestControllerAdvice("ru.sber.bracketschecker.controller")
public class ErrorHandler {
    @ExceptionHandler({
            JsonProcessingException.class,
            JsonFieldException.class,
            NullPointerException.class
            })
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String, String> invalidJsonException(final Exception e) {
        log.warn("Invalid json {}. Stacktrace {}", e.getMessage(), e.getCause());
        return Map.of("Wrong json has been sent", e.getMessage());
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Map<String, String> serverInternalError(final Exception e) {
        log.warn("Internal server error {}. Stacktrace {}", e.getMessage(), e.getCause());
        return Map.of("Internal server error", e.getMessage());
    }

}
