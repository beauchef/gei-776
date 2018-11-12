package blog.syntaxerror.domain.repository;

import blog.syntaxerror.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author beauchef on 2018-11-12.
 */
public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);
}
