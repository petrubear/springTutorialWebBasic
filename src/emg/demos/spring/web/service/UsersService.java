package emg.demos.spring.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import emg.demos.spring.web.dao.User;
import emg.demos.spring.web.dao.UsersDAO;

@Service("usersService")
public class UsersService {
	private UsersDAO usersDao;

	@Autowired
	public void setUsersDao(UsersDAO usersDao) {
		this.usersDao = usersDao;
	}

	public void create(User user) {
		this.usersDao.create(user);
	}

}
