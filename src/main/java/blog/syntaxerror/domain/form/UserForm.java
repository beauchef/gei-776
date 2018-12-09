package blog.syntaxerror.domain.form;

import lombok.Data;

import java.net.URLEncoder;

/**
 * @author beauchef on 2018-11-12.
 */
@Data
public class UserForm implements UrlEncodable {

    private Long id;
    private String name;
    private String email;
    private String password;

    @Override
    public String encode() {
        return String.format("name=%s&email=%s&password=%s", URLEncoder.encode(name), URLEncoder.encode(email),
                URLEncoder.encode(password));
    }
}
