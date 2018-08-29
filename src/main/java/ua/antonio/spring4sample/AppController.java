package ua.antonio.spring4sample;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/users")
public class AppController {

    @RequestMapping(method = RequestMethod.GET)
    public String list() {
        return "list";
    }


    // http://localhost:8080/users/showUser?userId=105
    @RequestMapping(value = "/showUser", method = RequestMethod.GET)
    public String showUserByRequestParam(@RequestParam("userId") Long id, Model model) {
        return "";
    }

    // http://localhost:8080/users/105
    @RequestMapping(value = "/{userId}", method = RequestMethod.GET)
    public String showUserByPathVariable(@PathVariable("userId") Long id, Model model) {
        return "";
    }

}
