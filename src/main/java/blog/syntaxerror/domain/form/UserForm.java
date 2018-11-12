package blog.syntaxerror.domain.form;

import lombok.Data;

/**
 * @author beauchef on 2018-11-12.
 */
@Data
public class UserForm {

    private String name;
    private String email;
    private String password;
}
