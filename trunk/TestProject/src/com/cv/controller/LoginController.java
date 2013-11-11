package com.cv.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
	@RequestMapping("/login.html")
	public String getLoginPage(@RequestParam(value = "error", required = false) boolean error,ModelMap model) {
		if (error) {
			model.put("error", "login.error");
		} else {
			model.put("error", "");
		}
		return "login";
	}
}
