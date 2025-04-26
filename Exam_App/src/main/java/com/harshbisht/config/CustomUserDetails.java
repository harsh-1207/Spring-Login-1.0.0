package com.harshbisht.config;

import java.util.Arrays;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.jackson2.SimpleGrantedAuthorityMixin;

import com.harshbisht.model.UserDtls;

public class CustomUserDetails implements UserDetails{
	
	public CustomUserDetails(UserDtls user) {
		super();
		this.user = user;
	}

	private UserDtls user;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority(user.getRole());
		return Arrays.asList(simpleGrantedAuthority);
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return user.getEmail();
	}
	
	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
//		return UserDetails.super.isAccountNonLocked();
		return true;
	}
	
	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
//		return UserDetails.super.isAccountNonExpired();
		return true;
	}
	
	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
//		return UserDetails.super.isCredentialsNonExpired();
		return true;
	}
	
	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
//		return UserDetails.super.isEnabled();
		return true;
	}
	
	
}
