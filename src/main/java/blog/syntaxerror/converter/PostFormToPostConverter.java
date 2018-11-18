package blog.syntaxerror.converter;

import blog.syntaxerror.domain.entity.Post;
import blog.syntaxerror.domain.form.PostForm;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * @author beauchef on 2018-11-18.
 */
@Component
public class PostFormToPostConverter implements Converter<PostForm, Post> {

    @Override
    public Post convert(PostForm postForm) {
        Post post = new Post();
        post.setId(postForm.getId());
        post.setTitle(postForm.getTitle());
        post.setText(postForm.getText());
        return post;
    }
}
