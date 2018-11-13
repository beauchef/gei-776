package blog.syntaxerror.domain.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

/**
 * @author beauchef on 2018-11-12.
 */
@Data
@EqualsAndHashCode(callSuper = false, exclude = {"user"})
@Entity
@Table(name = "posts")
public class Post {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "text", length = 50_000)
    private String text;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;
}
