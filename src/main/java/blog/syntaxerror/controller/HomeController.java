package blog.syntaxerror.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author beauchef on 2018-11-05.
 */
@Controller
public class HomeController {

    @GetMapping("/")
    public String root() {
        return "index";
    }

    @RequestMapping("/login")
    public String login() {
        return "login";
    }
}
