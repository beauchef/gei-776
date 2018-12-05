package blog.syntaxerror.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author beauchef on 2018-12-04.
 */
public class HtmlServiceTest {

    private HtmlService htmlService;

    @Before
    public void setup() {
        this.htmlService = new HtmlService();
    }

    @Test
    public void test_removeHtml() {
        Assert.assertEquals("Hello", htmlService.removeHtml("Hello"));
        Assert.assertEquals("Hello\nWorld!", htmlService.removeHtml("Hello\nWorld!"));
        Assert.assertEquals("2 &lt; 3", htmlService.removeHtml("2 &lt; 3"));
        Assert.assertEquals("Hello", htmlService.removeHtml("<p>Hello<p>"));
        Assert.assertEquals("Hello World!", htmlService.removeHtml("Hello <br />World!"));
        Assert.assertEquals("2 < 3", htmlService.removeHtml("2 < 3"));
    }
}
