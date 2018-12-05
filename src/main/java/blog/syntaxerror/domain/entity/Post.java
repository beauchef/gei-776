package blog.syntaxerror.domain.entity;

import blog.syntaxerror.validation.NoHtml;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

/**
 * @author beauchef on 2018-11-12.
 */
@Data
@EqualsAndHashCode(callSuper = false, exclude = {"user"})
@NoArgsConstructor
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "posts")
public class Post extends Auditable<User, Long> {

    public Post(Long id) {
        this.setId(id);
    }
    @Column(name = "title")
    private String title;

    @NoHtml
    @Column(name = "text", length = 50_000)
    private String text;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;
}
