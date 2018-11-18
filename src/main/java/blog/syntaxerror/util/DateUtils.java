package blog.syntaxerror.util;

import lombok.experimental.UtilityClass;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

/**
 * @author beauchef on 2018-11-18.
 */
@UtilityClass
public class DateUtils {

    private static final String UNKNOWN_DATE = "unknown date";
    private static final String DATETIME_FORMAT_STRING = "yyyy-MM-dd HH:mm";
    private static final String DATE_FORMAT_STRING = "yyyy-MM-dd";

    private static final DateTimeFormatter DATETIME_FORMATTER = DateTimeFormatter.ofPattern(DATETIME_FORMAT_STRING);
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern(DATE_FORMAT_STRING);

    public String formatDate(LocalDateTime date) {
        return date.format(DATE_FORMATTER);
    }

    public String formatDate(Optional<LocalDateTime> optionalDate) {
        return optionalDate.map(d -> d.format(DATE_FORMATTER)).orElse(UNKNOWN_DATE);
    }

    public String formatDateTime(LocalDateTime date) {
        return date.format(DATETIME_FORMATTER);
    }

    public String formatDateTime(Optional<LocalDateTime> optionalDate) {
        return optionalDate.map(d -> d.format(DATETIME_FORMATTER)).orElse(UNKNOWN_DATE);
    }
}
