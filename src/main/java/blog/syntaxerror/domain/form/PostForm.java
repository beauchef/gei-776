package blog.syntaxerror.domain.form;

import lombok.Data;

/**
 * @author beauchef on 2018-11-18.
 */
@Data
public class PostForm {

    private Long id;
    private String title;
    private String text;
}
