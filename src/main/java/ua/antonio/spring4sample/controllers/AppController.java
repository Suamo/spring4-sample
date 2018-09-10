package ua.antonio.spring4sample.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/users")
public class AppController {

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @PreAuthorize("hasRole('ADMIN')")
    public String list(Model model) {
        model.addAttribute("users", new String[]{"Valera", "Alena", "Zinaida"});
        return "list";
    }

    // http://localhost:8080/users/showUser?userId=105
    @GetMapping(value = "/showUser")
    public String showUserByRequestParam(@RequestParam("userId") Long id, Model model) {
        model.addAttribute("users", new String[]{"Valera?" + id});
        return "list";
    }

    // http://localhost:8080/users/105
    @RequestMapping(value = "/{userId}", method = RequestMethod.GET)
    public String showUserByPathVariable(@PathVariable("userId") Long id, Model model) {
        model.addAttribute("users", new String[]{"Valera/" + id});
        return "list";
    }

}
