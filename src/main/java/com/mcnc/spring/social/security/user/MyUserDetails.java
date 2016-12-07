package com.mcnc.spring.social.security.user;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.mcnc.spring.social.security.model.MyUserAccount;

public class MyUserDetails implements UserDetails {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private List<GrantedAuthority> list = new ArrayList<GrantedAuthority>();
	private MyUserAccount myUserAccount;

	public MyUserDetails(MyUserAccount myUserAccount) {
		this.myUserAccount = myUserAccount;
		String role = myUserAccount.getRole();
		
		GrantedAuthority grant = new SimpleGrantedAuthority(role);
		this.list.add(grant);
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return list;
	}

	@Override
	public String getPassword() {
		return myUserAccount.getPassword();
	}

	@Override
	public String getUsername() {
		return myUserAccount.getUserName();
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

	@Override
	public boolean isEnabled() {
		return myUserAccount.isEnabled();
	}

}
