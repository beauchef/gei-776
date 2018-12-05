package blog.syntaxerror.controller;

import blog.syntaxerror.web.HttpErrorCodeMapping;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

/**
 * @author beauchef on 2018-11-06.
 */
@Controller
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
}
