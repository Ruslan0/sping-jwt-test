package com.rsn.user.accounts.security.user;

import java.util.Collection;
import java.util.List;

import com.rsn.user.accounts.common.Role;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

public record AuthUser(String userId, List<Role> roles, String passwordHash) {

  public Collection<? extends GrantedAuthority> getAuthorities() {
    return roles.stream().map(role -> new SimpleGrantedAuthority(role.name())).toList();
  }
}