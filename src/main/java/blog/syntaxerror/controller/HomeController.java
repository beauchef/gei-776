package blog.syntaxerror.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author beauchef on 2018-11-05.
 */
@Controller
public class HomeController {

    @GetMapping("/")
    public String root() {
        return "index";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }
}
