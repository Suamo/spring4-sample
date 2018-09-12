package ua.antonio;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.security.RolesAllowed;

@Controller
public class SecuredController {

    @RolesAllowed("ADMIN")
    @GetMapping(value = "/adminPage")
    public String adminPage() {
        return "admin";
    }

    @GetMapping(value = "/userPage")
    public String userPage() {
        return "user";
    }

}
