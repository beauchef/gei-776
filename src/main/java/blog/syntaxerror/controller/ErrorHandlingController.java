package blog.syntaxerror.controller;

import blog.syntaxerror.web.HttpErrorCodeMapping;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolationException;

/**
 * @author beauchef on 2018-11-06.
 */
@Slf4j
@Controller
@ControllerAdvice
@RequestMapping("/error")
public class ErrorHandlingController implements ErrorController {

    @GetMapping
    public String error(HttpServletRequest request) {
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
        if (status != null) {
            return HttpErrorCodeMapping.getPathForStatusCode(Integer.valueOf(status.toString()));
        }
        return HttpErrorCodeMapping.DEFAULT_ERROR_PATH;
    }

    @GetMapping("/access-denied")
    public String accessDenied() {
        return HttpErrorCodeMapping.FORBIDDEN.getPath();
    }

    @GetMapping("/not-found")
    public String notFound() {
        return HttpErrorCodeMapping.NOT_FOUND.getPath();
    }

    @Override
    public String getErrorPath() {
        return "/error";
    }

    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    @ExceptionHandler(ConstraintViolationException.class)
    public void handleConstraintViolation() {
        log.error("ConstraintViolationException exception occurred...");
    }
}
