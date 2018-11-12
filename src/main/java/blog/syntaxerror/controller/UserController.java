package blog.syntaxerror.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author beauchef on 2018-11-06.
 */
@Controller
@Secured({ "ROLE_USER", "ROLE_ADMIN" })
@RequestMapping("/user")
public class UserController {

    @GetMapping
    public String root() {
        return "/user/index";
    }
}
