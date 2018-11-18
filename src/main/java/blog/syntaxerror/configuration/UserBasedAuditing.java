package blog.syntaxerror.configuration;

import blog.syntaxerror.domain.entity.User;
import blog.syntaxerror.service.UserService;
import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

/**
 * @author beauchef on 2018-11-18.
 */
public class UserBasedAuditing implements AuditorAware<User> {

    private final UserService userService;

    public UserBasedAuditing(UserService userService) {
        this.userService = userService;
    }

    @Override
    public Optional<User> getCurrentAuditor() {
        return Optional.of(userService.getPrincipal());
    }
}
