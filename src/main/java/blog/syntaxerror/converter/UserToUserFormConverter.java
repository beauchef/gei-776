package blog.syntaxerror.converter;

import blog.syntaxerror.domain.entity.User;
import blog.syntaxerror.domain.form.UserForm;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * @author beauchef on 2018-11-12.
 */
@Component
public class UserToUserFormConverter implements Converter<User, UserForm> {

    @Override
    public UserForm convert(User user) {
        UserForm userForm = new UserForm();
        userForm.setId(user.getId());
        userForm.setEmail(user.getEmail());
        userForm.setName(user.getDisplayName());
        userForm.setPassword(null); // Password set to null by default
        return userForm;
    }
}
