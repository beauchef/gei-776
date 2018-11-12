package blog.syntaxerror.controller;

import blog.syntaxerror.domain.form.UserForm;
import blog.syntaxerror.service.UserService;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author beauchef on 2018-11-06.
 */
@Controller
@Secured("ROLE_ADMIN")
@RequestMapping("/admin")
public class AdminController {

    private final UserService userService;

    public AdminController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String root(Model model) {
        model.addAttribute("users", userService.findAll());
        return "/admin/index";
    }

    @GetMapping("/add-user")
    public String addUser() {
        return "/admin/add-user";
    }

    @PostMapping("/add-user")
    public String saveUser(@ModelAttribute UserForm form) {
        userService.saveUser(form);
        return "redirect:/admin";
    }
}
