package com.hnq.fly.model.bo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import net.minidev.json.annotate.JsonIgnore;
import org.apache.commons.lang.StringUtils;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author henengqiang
 * @date 2020/3/16
 */
@Getter
@Setter
@ToString
public class LoginUser extends UserBO implements UserDetails {

    private static final long serialVersionUID = -643809129510451310L;

    private List<PermissionBO> permissions;

    private String token;

    /**
     * 登录时间戳（毫秒）
     */
    private Long loginTime;

    /**
     * 过期时间戳
     */
    private Long expireTime;

    @JsonIgnore
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return permissions.parallelStream().filter(p -> StringUtils.isNotEmpty(p.getPermissionName()))
                .map(p -> new SimpleGrantedAuthority(p.getPermissionName())).collect(Collectors.toSet());
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonLocked() {
        return Status.LOCKED.equals(getStatus());
    }

    @JsonIgnore
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isEnabled() {
        return true;
    }
}
