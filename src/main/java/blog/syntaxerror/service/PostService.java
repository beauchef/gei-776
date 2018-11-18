package blog.syntaxerror.service;

import blog.syntaxerror.domain.entity.Post;
import blog.syntaxerror.domain.entity.User;
import blog.syntaxerror.domain.enumeration.Role;
import blog.syntaxerror.domain.form.PostForm;
import blog.syntaxerror.domain.repository.PostRepository;
import blog.syntaxerror.exception.EntityNotFoundException;
import org.springframework.core.convert.ConversionService;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.data.domain.Sort.Direction.DESC;

/**
 * @author beauchef on 2018-11-12.
 */
@Service
@Transactional
public class PostService {

    private final PostRepository postRepository;
    private final UserService userService;
    private final ConversionService conversionService;

    public PostService(PostRepository postRepository, UserService userService, ConversionService conversionService) {
        this.postRepository = postRepository;
        this.userService = userService;
        this.conversionService = conversionService;
    }

    public List<Post> getPrincipalPosts() {
        User principal = userService.getPrincipal();
        return principal == null ? new ArrayList<>() : postRepository.findByUser(principal);
    }

    public void deletePost(long id) {
        User principal = userService.getPrincipal();
        List<Post> principalPosts = getPrincipalPosts(); // FIXME
        if (principal.getAuthorities().contains(Role.ROLE_ADMIN) ||
                principalPosts.stream().map(Post::getId).anyMatch(Long.valueOf(id)::equals)) {
            postRepository.deleteById(id);
        } else {
            throw new EntityNotFoundException(Post.class, id);
        }
    }

    public PostForm getPostForm(long id) {
        Post post = postRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(Post.class, id));
        return conversionService.convert(post, PostForm.class);
    }

    public PostForm savePost(PostForm postForm) {
        Post post;
        if (postForm.getId() == null) {
            post = conversionService.convert(postForm, Post.class);
            post.setUser(userService.getPrincipal());
        } else {
            long id = postForm.getId();
            post = postRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(Post.class, id));
            post.setTitle(postForm.getTitle());
            post.setText(postForm.getText());
        }
        return conversionService.convert(postRepository.save(post), PostForm.class);
    }

    public List<Post> findAll() {
        return postRepository.findAll(new Sort(DESC, "createdDate"));
    }
}
