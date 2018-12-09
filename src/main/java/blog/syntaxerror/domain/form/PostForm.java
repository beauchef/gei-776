package blog.syntaxerror.domain.form;

import lombok.Data;

import java.net.URLEncoder;

/**
 * @author beauchef on 2018-11-18.
 */
@Data
public class PostForm implements UrlEncodable {

    private Long id;
    private String title;
    private String text;
    private String html;

    @Override
    public String encode() {
        return String.format("title=%s&text=%s", URLEncoder.encode(title), URLEncoder.encode(text));
    }
}
