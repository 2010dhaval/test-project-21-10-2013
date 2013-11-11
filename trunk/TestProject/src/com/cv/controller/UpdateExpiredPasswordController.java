package com.cv.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.cv.model.CustomUserDetails;
import com.cv.model.Password;
import com.cv.model.User;
import com.cv.service.UserService;

@Controller
@RequestMapping("updateExpiredPassword.html")
@SessionAttributes("password")
public class UpdateExpiredPasswordController {
	@Autowired
	private UserService userService;

	@RequestMapping(method = RequestMethod.GET)
	public String showForm(ModelMap model) {
		Password password = new Password();
		CustomUserDetails curUser = (CustomUserDetails) (SecurityContextHolder
				.getContext().getAuthentication().getPrincipal());
		password.setUserId(curUser.getUserId());
		password.setUsername(curUser.getUsername());
		model.addAttribute("password", password);
		return "updateExpiredPassword";
	}

	@RequestMapping(method = RequestMethod.POST, params = "_update")
	private String updatePassword(
			final @ModelAttribute("password") Password password, Errors errors,
			SessionStatus sessionStatus, User user) {
		System.out.println("vvvvv");
		if (!this.userService.confirmPassword(password, user)) {
			// System.out.println("Nested path="+errors.getNestedPath());
			errors.rejectValue("oldPassword", "password is weong");
			System.out.println("conform");
			return "updateExpiredPassword";
		} else {
			this.userService.updatePassword(user, password);
			// all you need to do now is load the correct Authorities
			Authentication curAuthentication = SecurityContextHolder
					.getContext().getAuthentication();
			CustomUserDetails curUser = (CustomUserDetails) SecurityContextHolder
					.getContext().getAuthentication().getPrincipal();
			
			System.out.println("before" + curUser.getRole().getRoleId());
//			curUser.setBusinessFunction(this.userService
//					.getBusinessFunctionsForUserId(curUser.getRole()
//							.getRoleId()));
			curUser.setRoles(this.userService.getRolesForUserId(curUser.getRole().getRoleId()));
			System.out.println("After");
			
			UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(
					curUser, curAuthentication.getCredentials(),
					curUser.getAuthorities());
			auth.setDetails(curAuthentication.getDetails());
			SecurityContextHolder.getContext().setAuthentication(auth);
			curAuthentication = SecurityContextHolder.getContext()
					.getAuthentication();
			sessionStatus.setComplete();
			System.out.println("check it");
			return "redirect:index.html?msg=Password updated";
		}
	}

	@RequestMapping(method = RequestMethod.POST, params = "_logout")
	private String logout(SessionStatus sessionStatus) {
		sessionStatus.setComplete();
		return "redirect:j_spring_security_logout";
	}
}
