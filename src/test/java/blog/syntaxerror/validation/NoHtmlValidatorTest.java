package blog.syntaxerror.validation;

import blog.syntaxerror.service.HtmlService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author beauchef on 2018-12-04.
 */
public class NoHtmlValidatorTest {

    private NoHtmlValidator validator;

    @Before
    public void setup() {
        validator = new NoHtmlValidator(new HtmlService());
    }

    @Test
    public void test_validInputs() {
        Assert.assertTrue(validator.isValid("Hello", null));
        Assert.assertTrue(validator.isValid("Hello\nWorld!", null));
        Assert.assertTrue(validator.isValid("2 &lt; 3", null));
        Assert.assertTrue(validator.isValid("2 < 3", null));
    }

    @Test
    public void test_invalidInputs() {
        Assert.assertFalse(validator.isValid("<p>Hello<p>", null));
        Assert.assertFalse(validator.isValid("Hello<br />World!", null));
    }
}
