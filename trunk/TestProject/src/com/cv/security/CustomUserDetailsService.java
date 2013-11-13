package com.cv.security;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.cv.service.UserService;
import com.cv.vo.UserVO;

@Component
public class CustomUserDetailsService implements AuthenticationProvider {

	@Autowired
	private UserService userService;

	@Override
	@Transactional
	public Authentication authenticate(Authentication authentication)
			throws AuthenticationException {

		String userName = (String) authentication.getPrincipal();
		String password = (String) authentication.getCredentials();
		
		System.out.println("username " + userName + " pass -" + password);
		UserVO userVO = this.userService.getUserDetails(userName, password);

		if (userVO != null) {

			if (userVO.getRole() != null) {

				List<String> roles = this.userService.getRolesForUserId(userVO
						.getRole().getRoleId());

				List<GrantedAuthority> AUTHORITIES = new ArrayList<GrantedAuthority>();
				for (String role : roles) {
					AUTHORITIES.add(new GrantedAuthorityImpl(role));
				}
				Authentication returnAuthentication = new UsernamePasswordAuthenticationToken(
						userName, password, AUTHORITIES);

				return returnAuthentication;
			} else {
				throw new BadCredentialsException("No role assign to user");
			}

		} else {
			throw new BadCredentialsException("Username or Password is invalid");
		}

	}

	@Override
	@Transactional
	public boolean supports(Class<? extends Object> authentication) {

		return true;
	}

}
