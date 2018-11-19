package blog.syntaxerror.converter;

import blog.syntaxerror.domain.entity.Post;
import blog.syntaxerror.domain.form.PostForm;
import blog.syntaxerror.service.MarkDownService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * @author beauchef on 2018-11-18.
 */
@Component
public class PostToPostFormConverter implements Converter<Post, PostForm> {

    private final MarkDownService markDownService;

    public PostToPostFormConverter(MarkDownService markDownService) {
        this.markDownService = markDownService;
    }

    @Override
    public PostForm convert(Post post) {
        PostForm postForm = new PostForm();
        postForm.setId(post.getId());
        postForm.setTitle(post.getTitle());
        postForm.setText(post.getText());
        postForm.setHtml(markDownService.convertMarkDownToHtml(post.getText()));
        return postForm;
    }
}
