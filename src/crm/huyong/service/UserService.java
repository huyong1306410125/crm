package crm.huyong.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import crm.huyong.dao.UserDao;
import crm.huyong.entity.User;

@Transactional
public class UserService {
	private UserDao userDao;

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public User login(User user) {
		return userDao.login(user);
	}

	public List<User> findAllUser() {
		return userDao.findAllUser();
	}
	 
}
