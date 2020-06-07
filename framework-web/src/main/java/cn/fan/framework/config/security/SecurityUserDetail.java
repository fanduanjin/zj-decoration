package cn.fan.framework.config.security;

import cn.fan.model.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

/**
 * @Description
 * @Date 2020/4/24
 * @Create By admin
 */
public class SecurityUserDetail implements UserDetails {

    public User user;

    public SecurityUserDetail(User user) {
        this.user = user;
    }

    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    public String getPassword() {
        return user == null ? null : user.getPassword();
    }

    public String getUsername() {
        return user == null ? null : user.getUserName();
    }

    public boolean isAccountNonExpired() {
        return user == null ? false : true;
    }

    public boolean isAccountNonLocked() {
        return user == null ? false : true;
    }

    public boolean isCredentialsNonExpired() {
        return user == null ? false : true;
    }

    public boolean isEnabled() {
        return user == null ? false : true;
    }
}
