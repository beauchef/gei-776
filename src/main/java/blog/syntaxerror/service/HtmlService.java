package blog.syntaxerror.service;

import org.htmlcleaner.HtmlCleaner;
import org.springframework.stereotype.Service;

/**
 * @author beauchef on 2018-12-04.
 */
@Service
public class HtmlService {

    private HtmlCleaner htmlCleaner = new HtmlCleaner();

    public String removeHtml(String input) {
        return htmlCleaner.clean(input).getText().toString();
    }
}
