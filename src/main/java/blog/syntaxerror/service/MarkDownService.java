package blog.syntaxerror.service;

import org.commonmark.node.Node;
import org.commonmark.parser.Parser;
import org.commonmark.renderer.html.HtmlRenderer;
import org.springframework.stereotype.Service;

/**
 * @author beauchef on 2018-11-18.
 */
@Service
public class MarkDownService {

    public String convertMarkDownToHtml(String markDown) {
        Parser parser = Parser.builder().build();
        Node document = parser.parse(markDown);
        HtmlRenderer renderer = HtmlRenderer.builder().build();
        return renderer.render(document);
    }
}
