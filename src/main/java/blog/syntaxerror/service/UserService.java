package blog.syntaxerror.service;

import blog.syntaxerror.domain.entity.User;
import blog.syntaxerror.domain.form.UserForm;
import blog.syntaxerror.domain.repository.UserRepository;
import blog.syntaxerror.exception.EntityNotFoundException;
import org.springframework.core.convert.ConversionService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author beauchef on 2018-11-12.
 */
@Service
@Transactional
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    private final ConversionService conversionService;

    public UserService(UserRepository userRepository, ConversionService conversionService) {
        this.userRepository = userRepository;
        this.conversionService = conversionService;
    }

    @Override
    public UserDetails loadUserByUsername(String email) {
        return userRepository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException(email));
    }

    public User getPrincipal() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null && auth.getPrincipal() != null && auth.getPrincipal() instanceof User) {
            return (User)auth.getPrincipal();
        } else {
            throw new IllegalStateException("Could find a principal.");
        }
    }

    public void deleteUser(long id) {
        userRepository.deleteById(id);
    }

    public UserForm getUserForm(long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(User.class, id));
        return conversionService.convert(user, UserForm.class);
    }

    public UserForm saveUser(UserForm userForm) {
        User user = userRepository.save(conversionService.convert(userForm, User.class));
        return conversionService.convert(user, UserForm.class);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }
}
