package blog.syntaxerror.domain.entity;

import blog.syntaxerror.domain.enumeration.Role;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static lombok.AccessLevel.PRIVATE;

/**
 * @author beauchef on 2018-11-05.
 */
@Data
@EqualsAndHashCode(callSuper = false, exclude = {"posts"})
@NoArgsConstructor
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "users", uniqueConstraints = {
        @UniqueConstraint(name = "uk_users_email", columnNames = {"email"}),
        @UniqueConstraint(name = "uk_users_name", columnNames = {"display_name"})
})
public class User extends Auditable<User, Long> implements UserDetails {

    public User(Long id) {
        this.setId(id);
    }

    @Column(name = "password")
    private String password;

    @Column(name = "display_name")
    private String displayName;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "is_enabled", nullable = false)
    private boolean enabled = false;

    @ElementCollection(targetClass=Role.class, fetch=FetchType.EAGER)
    @Enumerated(EnumType.STRING)
    @CollectionTable(name="user_roles", joinColumns = {@JoinColumn(name="user_id")})
    @Column(name="role_name")
     private Collection<Role> authorities;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    @Setter(PRIVATE)
    private List<Post> posts = new ArrayList<>();

    public void addPost(Post post) {
        posts.add(post);
        post.setUser(this);
    }

    public void removePost(Post post) {
        posts.remove(post);
        post.setUser(null);
    }

    public boolean hasRole(String role) {
        return authorities.stream().anyMatch(r -> role.equals(r.name()));
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
}
