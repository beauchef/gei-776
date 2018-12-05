package blog.syntaxerror.web;

import lombok.Getter;

import java.util.Optional;
import java.util.stream.Stream;

/**
 * @author beauchef on 2018-11-12.
 */
public enum HttpErrorCodeMapping {

    FORBIDDEN(403, "/error/403"),
    NOT_FOUND(404, "/error/404");

    public static final String DEFAULT_ERROR_PATH = "error";

    @Getter
    private int statusCode;
    @Getter
    private String path;

    HttpErrorCodeMapping(int statusCode, String path) {
        this.statusCode= statusCode;
        this.path = path;
    }

    public static Optional<HttpErrorCodeMapping> fromStatusCode(int statusCode) {
        return Stream.of(HttpErrorCodeMapping.values())
                .filter(h -> h.getStatusCode() == statusCode)
                .findFirst();
    }

    public static String getPathForStatusCode(int statusCode) {
        Optional<HttpErrorCodeMapping> mapping = HttpErrorCodeMapping.fromStatusCode(statusCode);
        return mapping.isPresent() ? mapping.get().getPath() : DEFAULT_ERROR_PATH;
    }
}
