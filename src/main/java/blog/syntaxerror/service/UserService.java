package blog.syntaxerror.service;

import blog.syntaxerror.domain.entity.User;
import blog.syntaxerror.domain.enumeration.Role;
import blog.syntaxerror.domain.form.UserForm;
import blog.syntaxerror.domain.repository.UserRepository;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

/**
 * @author beauchef on 2018-11-12.
 */
@Service
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, @Lazy BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email);
        if (user == null) {
            throw new UsernameNotFoundException(email);
        }
        return user;
    }

    public void saveUser(UserForm userForm) {
        User user = new User();
        user.setDisplayName(userForm.getName());
        user.setEmail(userForm.getEmail());
        user.setPassword(passwordEncoder.encode(userForm.getPassword()));
        user.setEnabled(true);
        user.setAuthorities(Collections.singletonList(Role.ROLE_USER));
        userRepository.save(user);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }
}
