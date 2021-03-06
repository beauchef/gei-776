package blog.syntaxerror.controller;

import blog.syntaxerror.service.PostService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author beauchef on 2018-11-05.
 */
@Controller
public class HomeController {

    private final PostService postService;

    public HomeController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/")
    public String root(Model model) {
        model.addAttribute("posts", postService.findAll());
        return "index";
    }

    @RequestMapping("/login")
    public String login() {
        return "login";
    }
}
