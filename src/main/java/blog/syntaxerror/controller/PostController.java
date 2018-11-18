package blog.syntaxerror.controller;

import blog.syntaxerror.service.PostService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author beauchef on 2018-11-18.
 */
@Controller
@RequestMapping("/post")
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/{id}")
    public String display(@PathVariable("id") long id, Model model) {
        model.addAttribute("post", postService.getPostForm(id));
        return "post/display";
    }
}
