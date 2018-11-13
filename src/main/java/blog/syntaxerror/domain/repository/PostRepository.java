package blog.syntaxerror.domain.repository;

import blog.syntaxerror.domain.entity.Post;
import blog.syntaxerror.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author beauchef on 2018-11-12.
 */
public interface PostRepository extends JpaRepository<Post, Long> {

    List<Post> findByUser(User user);
}
