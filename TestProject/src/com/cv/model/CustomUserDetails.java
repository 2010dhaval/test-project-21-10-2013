package com.cv.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class CustomUserDetails implements UserDetails {

	private int userId;
	private String username;
	private String password;
	private List<SimpleGrantedAuthority> roles;
	private Role role;

	public CustomUserDetails(User userTemp) {
		this.setUsername(userTemp.getUsername());
		this.setUserId(userTemp.getUserId());
		this.setPassword(userTemp.getPassword());
		this.setRole(userTemp.getRole());

	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public List<SimpleGrantedAuthority> getRoles() {
		return roles;
	}

	public void setRoles(List<String> roles) {
		List<SimpleGrantedAuthority> finalRoles = new ArrayList<SimpleGrantedAuthority>();
		for (String bf : roles) {
			finalRoles.add(new SimpleGrantedAuthority(bf));
			System.out.println("bf ---"+bf);
		}
		this.roles = finalRoles;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		 return this.roles;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return username;
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

		return true;
	}

}
