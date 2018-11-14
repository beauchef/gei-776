package blog.syntaxerror.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author beauchef on 2018-11-06.
 */
@Controller
@RequestMapping("/info")
public class InfoController {

    @GetMapping
    public String root() {
        return "info/index";
    }
}
