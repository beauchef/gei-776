package blog.syntaxerror.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author beauchef on 2018-11-12.
 */
@Controller
@RequestMapping("/article")
public class ArticleController {

    @GetMapping
    public String root() {
        return "article/index";
    }
}
