package blog.syntaxerror.service;

import blog.syntaxerror.domain.entity.Post;
import blog.syntaxerror.domain.entity.User;
import blog.syntaxerror.domain.repository.PostRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author beauchef on 2018-11-12.
 */
@Service
public class PostService {

    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public List<Post> getPrincipalPosts() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = null;
        if (auth != null && auth.getPrincipal() != null && auth.getPrincipal() instanceof User) {
            user = (User)auth.getPrincipal();
        }
        return user == null ? new ArrayList<>() : postRepository.findByUser(user);
    }
}
