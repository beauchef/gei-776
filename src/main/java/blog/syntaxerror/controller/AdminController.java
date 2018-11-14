package blog.syntaxerror.controller;

import blog.syntaxerror.domain.form.UserForm;
import blog.syntaxerror.service.UserService;
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
        return "admin/index";
    }

    @GetMapping("/user/{id}/delete")
    public String deleteUser(@PathVariable("id") long id, RedirectAttributes redirectAttributes) {
        log.info("Deleting user ID {}.", id);
        userService.deleteUser(id);
        return "redirect:/admin";
    }

    @GetMapping("/user/{id}/edit")
    public String editUser(@PathVariable("id") long id, Model model) {
        model.addAttribute("user", userService.getUserForm(id));
        return "admin/edit-user";
    }

    @GetMapping("/user/add")
    public String addUser(Model model) {
        model.addAttribute("user", new UserForm());
        return "admin/edit-user";
    }

    @PostMapping("/user/save")
    public String saveUser(@ModelAttribute UserForm form) {
        userService.saveUser(form);
        return "redirect:/admin";
    }
}
