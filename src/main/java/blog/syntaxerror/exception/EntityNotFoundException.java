package blog.syntaxerror.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author beauchef on 2018-11-12.
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class EntityNotFoundException extends RuntimeException {

    private static final long serialVersionUID = -6395953723757902372L;

    public EntityNotFoundException(Class clazz, long id) {
        super(String.format("Cannot find entity of type '%s' with ID %d.", clazz.getSimpleName(), id));
    }
}
