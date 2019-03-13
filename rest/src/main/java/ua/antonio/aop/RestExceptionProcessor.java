package ua.antonio.aop;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import ua.antonio.SimpleRestController.MyException3;
import ua.antonio.domain.JsonError;

@ControllerAdvice
public class RestExceptionProcessor {

    @ExceptionHandler({MyException3.class})
    @ResponseStatus(value = HttpStatus.ACCEPTED) //todo: doesn't work. check
    public JsonError handleException(MyException3 ex) {
        System.out.println("-<>- RestExceptionProcessor.exception");
        return new JsonError(ex.getMessage());
    }

}
