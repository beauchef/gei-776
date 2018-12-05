package blog.syntaxerror.validation;

import blog.syntaxerror.service.HtmlService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author beauchef on 2018-12-04.
 */
public class NoHtmlValidator implements ConstraintValidator<NoHtml, String> {

    private final HtmlService htmlService;

    @Autowired
    public NoHtmlValidator(HtmlService htmlService) {
        this.htmlService = htmlService;
    }

    @Override
    public boolean isValid(String input, ConstraintValidatorContext constraintValidatorContext) {
        return htmlService.removeHtml(input).equals(input);
    }
}
