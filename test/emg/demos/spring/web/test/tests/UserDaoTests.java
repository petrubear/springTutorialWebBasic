package emg.demos.spring.web.test.tests;

import static org.junit.Assert.*;

import java.util.List;

import javax.sql.DataSource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import emg.demos.spring.web.dao.User;
import emg.demos.spring.web.dao.UsersDao;

@ActiveProfiles("dev")
@ContextConfiguration(locations = {
		"classpath:emg/demos/spring/web/test/config/datasource.xml",
		"classpath:emg/demos/spring/web/config/dao-context.xml",
		"classpath:emg/demos/spring/web/config/security-context.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class UserDaoTests {

	@Autowired
	private UsersDao usersDao;

	@Autowired
	private DataSource dataSource;

	@Before
	public void init() {
		JdbcTemplate jdbc = new JdbcTemplate(dataSource);

		jdbc.execute("delete from users");
		jdbc.execute("delete from authorities");
	}

	@Test
	public void testCreateUser() {
		User user = new User("edison", "edison", "email@email", true, "none");
		assertTrue("Should be true for user creation", usersDao.create(user));

		List<User> users = usersDao.getAllUsers();
		assertEquals("Total users should be 1", 1, users.size());
		
		assertEquals("User edison should exists", true, usersDao.exists(user.getUsername()));
	}
}
