package blog.syntaxerror.test;

import blog.syntaxerror.domain.entity.User;
import blog.syntaxerror.domain.enumeration.Role;
import blog.syntaxerror.domain.form.MockPostForm;
import blog.syntaxerror.domain.form.MockUserForm;

import java.util.Arrays;
import java.util.Collections;

/**
 * @author beauchef on 2018-12-09.
 */
public class MockFactory {

    public static User blogger() {
        User blogger = new User();
        blogger.setAuthorities(Collections.singletonList(Role.ROLE_USER));
        blogger.setEmail("user@syntaxerror.blog");
        blogger.setPassword("password");
        blogger.setDisplayName("blogger");
        return blogger;
    }

    public static User admin() {
        User admin = new User();
        admin.setAuthorities(Arrays.asList(Role.ROLE_USER, Role.ROLE_ADMIN));
        admin.setEmail("admin@syntaxerror.blog");
        admin.setPassword("password");
        admin.setDisplayName("admin");
        return admin;
    }

    public static User moderator() {
        User admin = new User();
        admin.setAuthorities(Collections.singletonList(Role.ROLE_ADMIN));
        admin.setEmail("moderator@syntaxerror.blog");
        admin.setPassword("password");
        admin.setDisplayName("moderator");
        return admin;
    }

    public static MockUserForm userForm(String email) {
        MockUserForm form = new MockUserForm();
        form.setEmail(email);
        form.setName("New User");
        form.setPassword("new_password");
        return form;
    }

    public static MockPostForm postForm() {
        MockPostForm form = new MockPostForm();
        form.setTitle("Post title");
        form.setText("# Post\nThis is a post...");
        return form;
    }
}
