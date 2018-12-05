package blog.syntaxerror.domain.entity;

import blog.syntaxerror.util.DateUtils;
import org.springframework.data.jpa.domain.AbstractAuditable;

import java.io.Serializable;

/**
 * @author beauchef on 2018-11-18.
 */
public abstract class Auditable<U, K extends Serializable> extends AbstractAuditable<U, K> {

    public String getCreatedDatePretty() {
        return DateUtils.formatDateTime(getCreatedDate());
    }

    public String getLastModifiedDatePretty() {
        return DateUtils.formatDateTime(getLastModifiedDate());
    }
}
