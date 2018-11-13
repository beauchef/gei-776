package blog.syntaxerror.domain.enumeration;

import org.springframework.security.core.GrantedAuthority;

/**
 * @author beauchef on 2018-11-12.
 */
public enum Role implements GrantedAuthority {

    ROLE_USER,
    ROLE_ADMIN;

    @Override
    public String getAuthority() {
        return name();
    }
}
