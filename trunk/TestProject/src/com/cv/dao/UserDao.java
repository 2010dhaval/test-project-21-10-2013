package com.cv.dao;

import java.util.List;

import com.cv.model.Password;
import com.cv.model.User;

public interface UserDao {

	public boolean confirmPassword(Password password, User user);

	public void updatePassword(User user, Password password);

	public List<String> getRolesForUserId(String roleId);
	
	public  User getUserDetails(String username,String password);

}
