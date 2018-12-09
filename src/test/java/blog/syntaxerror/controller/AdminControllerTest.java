package blog.syntaxerror.controller;

import blog.syntaxerror.Application;
import blog.syntaxerror.domain.entity.User;
import blog.syntaxerror.domain.repository.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;

import static blog.syntaxerror.test.MockFactory.*;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author beauchef on 2018-12-09.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
@AutoConfigureMockMvc
public class AdminControllerTest {

    private static final String EMAIL = "new.user@example.com";

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private UserRepository userRepository;

    @Before
    public void setup() {
        // Make sure to delete the created user in the test, to avoid
        // constraint violation exception because of non-unique email.
        Optional<User> newUser = userRepository.findByEmail(EMAIL);
        newUser.ifPresent(user -> userRepository.delete(user));
    }

    @Test
    public void test_saveUser_withoutSecurity() throws Exception {
        this.mockMvc.perform(post("/admin/user/save")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .content(userForm(EMAIL).encode()))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/error/access-denied")); // redirect to access denied page
    }

    @Test
    public void test_saveUser_withAdmin() throws Exception {
        this.mockMvc.perform(post("/admin/user/save")
                .with(csrf())
                .with(user(admin()))
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .content(userForm(EMAIL).encode()))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/admin")); // redirect to admin page
    }

    @Test
    public void test_saveUser_withBlogger() throws Exception {
        this.mockMvc.perform(post("/admin/user/save")
                .with(csrf())
                .with(user(blogger()))
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .content(userForm(EMAIL).encode()))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/error/access-denied")); // redirect to access denied page
    }

    @Test
    public void test_saveUser_withModerator() throws Exception {
        this.mockMvc.perform(post("/admin/user/save")
                .with(csrf())
                .with(user(moderator()))
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .content(userForm(EMAIL).encode()))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/admin")); // redirect to admin page
    }
}
