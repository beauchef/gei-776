package blog.syntaxerror.domain.form;

import java.net.URLEncoder;

/**
 * @author beauchef on 2018-12-09.
 */
public class MockPostForm extends PostForm implements UrlEncodable {

    @Override
    public String encode() {
        return String.format("title=%s&text=%s", URLEncoder.encode(getTitle()), URLEncoder.encode(getText()));
    }
}
