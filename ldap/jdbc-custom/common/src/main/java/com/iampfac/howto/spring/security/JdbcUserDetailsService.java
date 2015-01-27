package com.iampfac.howto.spring.security;

import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface JdbcUserDetailsService extends UserDetailsService {

	public List<GrantedAuthority> loadGroupAuthorities(String username);
}
