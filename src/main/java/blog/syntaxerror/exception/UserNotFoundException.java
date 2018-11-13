package blog.syntaxerror.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author beauchef on 2018-11-12.
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class UserNotFoundException extends RuntimeException {

    private static final long serialVersionUID = -6395953723757902372L;

    public UserNotFoundException(long id) {
        super(String.format("Cannot find user ID %d.", id));
    }
}
