package com.cv.service;

import java.util.List;

import com.cv.model.Password;
import com.cv.model.User;

public interface UserService {

	public boolean confirmPassword(Password password, User user);

	public void updatePassword(User user, Password password);

	public List<String> getRolesForUserId(String roleId);

}
