package blog.syntaxerror.domain.entity;

import blog.syntaxerror.domain.enumeration.Role;
import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Setter;
import org.springframework.data.jpa.domain.AbstractAuditable;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;

/**
 * @author beauchef on 2018-11-05.
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "users", uniqueConstraints = {
        @UniqueConstraint(name = "uk_users_email", columnNames = {"email"}),
        @UniqueConstraint(name = "uk_users_name", columnNames = {"display_name"})
})
public class User extends AbstractAuditable<User, Long> implements UserDetails {

    @Id
    @GeneratedValue
    @Setter(AccessLevel.PROTECTED)
    private Long id;

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
    Collection<Role> authorities;

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
