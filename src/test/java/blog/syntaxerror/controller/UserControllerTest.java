package blog.syntaxerror.controller;

import blog.syntaxerror.Application;
import blog.syntaxerror.domain.form.PostForm;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

import static blog.syntaxerror.test.MockFactory.*;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author beauchef on 2018-12-05.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
@AutoConfigureMockMvc
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void test_savePost_withoutSecurity() throws Exception {
        PostForm form = new PostForm();
        form.setTitle("Post title");
        form.setText("# Post\nThis is a post...");

        this.mockMvc.perform(post("/user/post/save")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .content(postForm().encode()))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/error/access-denied")); // redirect to access denied page
    }

    @Test
    public void test_savePost_withAdmin() throws Exception {
        this.mockMvc.perform(post("/user/post/save")
                .with(csrf())
                .with(user(admin()))
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .content(postForm().encode()))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/user")); // redirect to user page
    }

    @Test
    public void test_savePost_withBlogger() throws Exception {
        this.mockMvc.perform(post("/user/post/save")
                .with(csrf())
                .with(user(blogger()))
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .content(postForm().encode()))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/user")); // redirect to user page
    }


    @Test
    public void test_savePost_withModerator() throws Exception {
        this.mockMvc.perform(post("/user/post/save")
                .with(csrf())
                .with(user(moderator()))
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .content(postForm().encode()))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/error/access-denied")); // redirect to access denied page
    }
}
