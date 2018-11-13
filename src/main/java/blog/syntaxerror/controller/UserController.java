package blog.syntaxerror.controller;

import blog.syntaxerror.service.PostService;
import blog.syntaxerror.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * @author beauchef on 2018-11-06.
 */
@Slf4j
@Controller
@Secured({ "ROLE_USER", "ROLE_ADMIN" })
@RequestMapping("/user")
public class UserController {

    private final UserService userService;
    private final PostService postService;

    public UserController(UserService userService, PostService postService) {
        this.userService = userService;
        this.postService = postService;
    }

    @GetMapping
    public String root(Model model) {
        model.addAttribute("posts", postService.getPrincipalPosts());
        return "/user/index";
    }

    @GetMapping("/post/{id}/delete")
    public String deletePost(@PathVariable("id") long id, RedirectAttributes redirectAttributes) {
        log.info("Deleting post ID {}.", id); // TODO
        return "redirect:/user";
    }

    @GetMapping("/post/{id}/edit")
    public String editPost(@PathVariable("id") long id, Model model) {
        log.info("Editing post ID {}.", id); // TODO
        return "redirect:/user";
    }
}
