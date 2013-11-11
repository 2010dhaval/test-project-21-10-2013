/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cv.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

@Entity
@Table(name = "users")
public class User implements Serializable {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private int userId;
	@Column(name = "login")
	private String username;
	@Column(name = "password")
	private String password;
	@OneToOne()
	@JoinTable(name = "user_roles", joinColumns = { @JoinColumn(name = "user_id") }, inverseJoinColumns = { @JoinColumn(name = "role_id") })
	private Role role;

	public User() {
	}

	public User(CustomUserDetails userTemp) {
		this.setUsername(userTemp.getUsername());
		this.setUserId(userTemp.getUserId());
		this.setPassword(userTemp.getPassword());
		this.setRole(userTemp.getRole());
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
}
