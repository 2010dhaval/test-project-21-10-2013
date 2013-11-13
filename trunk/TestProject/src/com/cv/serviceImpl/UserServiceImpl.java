package com.cv.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cv.dao.UserDao;
import com.cv.model.Password;
import com.cv.model.User;
import com.cv.service.UserService;
import com.cv.vo.UserVO;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Override
	public boolean confirmPassword(Password password, User user) {
		return this.userDao.confirmPassword(password, user);
	}

	@Override
	public void updatePassword(User user, Password password) {
		this.userDao.updatePassword(user, password);

	}

	@Override
	public List<String> getRolesForUserId(String roleId) {
		return this.userDao.getRolesForUserId(roleId);
	}

	@Override
	public UserVO getUserDetails(String username, String password) {
		User user = this.userDao.getUserDetails(username, password);
		if (user != null) {
			UserVO userVO = new UserVO();
			userVO.setPassword(user.getPassword());
			userVO.setRole(user.getRole());
			userVO.setUserId(user.getUserId());
			userVO.setUsername(user.getUsername());
			return userVO;

		}
		return null;
	}

}
