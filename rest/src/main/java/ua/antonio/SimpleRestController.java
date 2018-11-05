package ua.antonio;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController // union of @Controller and @ResponseBody
@RequestMapping("/users")
public class SimpleRestController {

    @ResponseStatus(HttpStatus.VARIANT_ALSO_NEGOTIATES)
    @ExceptionHandler({MyException.class})
    public void handleNotFound() {
        System.out.println("-<>- Intercepting all MyException and returning 506 status code to client side.");
    }

    @GetMapping(value = "/list")
    public String list() {
        throw new MyException("Ooops");
    }

    @GetMapping(value = "/list2")
    public String list2() {
        throw new MyException2();
    }

    @ResponseStatus(HttpStatus.EXPECTATION_FAILED)
    @GetMapping(value = "/list3")
    public void list3() {
        System.out.println("Just returning 417 status code for /list3 requests");
    }

    @GetMapping(value = "/list4")
    public void list4() {
        throw new MyException3("Intercepting MyException3 with @ControllerAdvice and returning 409 status code to client side.");
    }


    class MyException extends IllegalArgumentException {
        MyException(String s) {
            super(s);
        }
    }

    @ResponseStatus(HttpStatus.I_AM_A_TEAPOT)
    class MyException2 extends IllegalArgumentException {
        MyException2() {
            super("Intercepting all MyException2 and returning 418 status code to client side.");
        }
    }

    public static class MyException3 extends IllegalArgumentException {
        MyException3(String s) {
            super(s);
        }
    }
}
