package blog.syntaxerror.validation;

import blog.syntaxerror.service.HtmlService;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author beauchef on 2018-12-04.
 */
@Component
public class NoHtmlValidator implements ConstraintValidator<NoHtml, String> {

    @Override
    public boolean isValid(String input, ConstraintValidatorContext constraintValidatorContext) {
        return new HtmlService().removeHtml(input).equals(input);
    }
}
