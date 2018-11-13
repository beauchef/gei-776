package blog.syntaxerror.service;

import blog.syntaxerror.domain.entity.User;
import blog.syntaxerror.domain.form.UserForm;
import blog.syntaxerror.domain.repository.UserRepository;
import blog.syntaxerror.exception.UserNotFoundException;
import org.springframework.core.convert.ConversionService;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author beauchef on 2018-11-12.
 */
@Service
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    private final ConversionService conversionService;

    public UserService(UserRepository userRepository, ConversionService conversionService) {
        this.userRepository = userRepository;
        this.conversionService = conversionService;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userRepository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException(email));
    }

    public User getPrincipal() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = null;
        if (auth != null && auth.getPrincipal() != null && auth.getPrincipal() instanceof User) {
            user = (User)auth.getPrincipal();
        }
        return user;
    }

    public void deleteUser(long id) {
        userRepository.deleteById(id);
    }

    public UserForm getUserForm(long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
        return conversionService.convert(user, UserForm.class);
    }

    public void saveUser(UserForm userForm) {
        userRepository.save(conversionService.convert(userForm, User.class));
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }
}
