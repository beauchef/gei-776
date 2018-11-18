package blog.syntaxerror.configuration;

import blog.syntaxerror.domain.entity.User;
import blog.syntaxerror.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/**
 * @author beauchef on 2018-11-18.
 */
@Configuration
@EnableJpaAuditing(auditorAwareRef="auditorProvider")
public class ApplicationConfiguration {

    @Bean
    AuditorAware<User> auditorProvider(@Lazy UserService userService) {
        return new UserBasedAuditing(userService);
    }
}
