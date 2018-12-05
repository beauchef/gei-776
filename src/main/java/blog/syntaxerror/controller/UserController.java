package blog.syntaxerror.controller;

import blog.syntaxerror.domain.form.PostForm;
import blog.syntaxerror.service.PostService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * @author beauchef on 2018-11-06.
 */
@Slf4j
@Controller
@Secured({ "ROLE_USER", "ROLE_ADMIN" })
@RequestMapping("/user")
public class UserController {

    private final PostService postService;

    public UserController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping
    public String root(Model model) {
        model.addAttribute("posts", postService.getPrincipalPosts());
        return "user/index";
    }

    @GetMapping("/post/{id}/delete")
    public String deletePost(@PathVariable("id") long id, RedirectAttributes redirectAttributes) {
        postService.deletePost(id);
        log.info("Deleted post ID {}.", id);
        return "redirect:/user";
    }

    @GetMapping("/post/{id}/edit")
    public String editPost(@PathVariable("id") long id, Model model) {
        log.info("Going to edit form for post ID {}.", id);
        model.addAttribute("post", postService.getPostForm(id));
        return "user/edit-post";
    }

    @GetMapping("/post/add")
    public String addPost(Model model) {
        log.info("Going to new post creation form.");
        model.addAttribute("post", new PostForm());
        return "user/edit-post";
    }

    @PostMapping("/post/save")
    public String savePost(@ModelAttribute PostForm form) {
        PostForm savedPost = postService.savePost(form);
        log.info("Saved post ID {}.", savedPost.getId());
        return "redirect:/user";
    }
}
