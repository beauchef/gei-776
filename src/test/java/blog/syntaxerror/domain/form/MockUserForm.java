package blog.syntaxerror.domain.form;

import java.net.URLEncoder;

/**
 * @author beauchef on 2018-12-09.
 */
public class MockUserForm extends UserForm implements UrlEncodable {

    @Override
    public String encode() {
        return String.format("name=%s&email=%s&password=%s", URLEncoder.encode(getName()),
                URLEncoder.encode(getEmail()), URLEncoder.encode(getPassword()));
    }
}
