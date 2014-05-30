package emg.demos.spring.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import emg.demos.spring.web.dao.User;
import emg.demos.spring.web.dao.UsersDao;

@Service("usersService")
public class UsersService {
	private UsersDao usersDao;

	@Autowired
	public void setUsersDao(UsersDao usersDao) {
		this.usersDao = usersDao;
	}

	public void create(User user) {
		this.usersDao.create(user);
	}

	public boolean exists(String username) {
		return usersDao.exists(username);
	}

	public List<User> getAllUsers() {
		return usersDao.getAllUsers();
	}

}
