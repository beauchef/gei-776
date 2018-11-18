package blog.syntaxerror.converter;

import blog.syntaxerror.domain.entity.User;
import blog.syntaxerror.domain.enumeration.Role;
import blog.syntaxerror.domain.form.UserForm;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Collections;

/**
 * @author beauchef on 2018-11-12.
 */
@Component
public class UserFormToUserConverter implements Converter<UserForm, User> {

    private final BCryptPasswordEncoder passwordEncoder;

    public UserFormToUserConverter(@Lazy BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.passwordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public User convert(UserForm userForm) {
        User user = new User(userForm.getId());
        user.setDisplayName(userForm.getName());
        user.setEmail(userForm.getEmail());
        user.setPassword(passwordEncoder.encode(userForm.getPassword()));
        user.setEnabled(true);
        user.setAuthorities(Collections.singletonList(Role.ROLE_USER));
        return user;
    }
}
