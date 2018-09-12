package ua.antonio.spring4sample.aop.rest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import ua.antonio.spring4sample.domain.JsonError;

@ControllerAdvice
public class RestExceptionProcessor {

    @ExceptionHandler({Exception.class})
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    @ResponseBody
    public JsonError handleException(Exception ex) {
        System.out.println("-<>- RestExceptionProcessor.exception");
        return new JsonError(ex.getMessage());
    }

}
