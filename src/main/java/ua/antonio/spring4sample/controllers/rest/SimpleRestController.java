package ua.antonio.spring4sample.controllers.rest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController // union of @Controller and @ResponseBody
@RequestMapping("/users")
public class SimpleRestController {

    /**
     * Maps IllegalArgumentExceptions to a 404 Not Found HTTP status code.
     */
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler({IllegalArgumentException.class})
    public void handleNotFound() {
        System.out.println("-<>- SimpleRestController.handleNotFound");
    }

    @GetMapping(value = "/list")
    public String list() {
        throw new IllegalArgumentException("Ooops");
    }

    @GetMapping(value = "/list2")
    public String list2() {
        throw new RuntimeException("Ooops2");
    }

}
