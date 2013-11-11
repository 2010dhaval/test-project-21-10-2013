package com.cv.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cv.model.CustomUserDetails;

@Controller
@RequestMapping("accessDenied.html")
public class AccessDeniedController {
	@RequestMapping(method = RequestMethod.GET)
	public String showPage() {
		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();
		if (auth != null) {
			if (auth.isAuthenticated()) {
				CustomUserDetails curUser = (CustomUserDetails) (SecurityContextHolder
						.getContext().getAuthentication().getPrincipal());
				if (curUser.getRoles().contains(
						new SimpleGrantedAuthority("admin"))) {
					return "redirect:updateExpiredPassword.html";
				} else {
					return "redirect:index.html";
				}
			}
		}
		return "accessDenied";
	}
}
