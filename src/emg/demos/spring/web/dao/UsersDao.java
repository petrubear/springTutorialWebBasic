package emg.demos.spring.web.dao;

import java.util.List;

import javax.sql.DataSource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

//import org.springframework.jdbc.core.JdbcTemplate;

@Component("usersDao")
@Transactional
public class UsersDao {
	// private JdbcTemplate jdbc;
	private NamedParameterJdbcTemplate jdbc;
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	public void setDataSource(DataSource jdbc) {
		// this.jdbc = new JdbcTemplate(jdbc);
		this.jdbc = new NamedParameterJdbcTemplate(jdbc);
	}

	public Session session(){
		return sessionFactory.getCurrentSession();
	}
	
	@Transactional
	public void create(User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		session().save(user);
	}
	//using jdbc 
	/*
	@Transactional
	public boolean create(User user) {
		// BeanPropertySqlParameterSource params = new
		// BeanPropertySqlParameterSource(user);
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("username", user.getUsername());
		params.addValue("password", passwordEncoder.encode(user.getPassword()));
		params.addValue("email", user.getEmail());
		params.addValue("enabled", user.isEnabled());
		params.addValue("authority", user.getAuthority());
		params.addValue("name", user.getName());

		String sqlQuery = "insert into `users` (`username`, `password`, `email`, `name`, `authority`) values (:username,:password,:email,:name,:authority);";
		// String sqlQuery2 =
		// "insert into `authorities` (`username`, `authority`) values (:username,:authority);";
		// jdbc.update(sqlQuery, params);
		return jdbc.update(sqlQuery, params) == 1;
	}
*/
	public boolean exists(String username) {
		return jdbc.queryForObject(
				"select count(*) from `users` where `username` = :username;",
				new MapSqlParameterSource("username", username), Integer.class) > 0;
	}

	@SuppressWarnings("unchecked")
	public List<User> getAllUsers() {
		//using hibernate
		return session().createQuery("from User").list();
		
		//using apache commons jdbc
		/*
		String sqlQuery = "SELECT * FROM users";
		return jdbc.query(sqlQuery,
				BeanPropertyRowMapper.newInstance(User.class));
				*/
		// return
		// jdbc.query("SELECT * FROM users, authorities WHERE users.username = authorities.username",BeanPropertyRowMapper.newInstance(User.class));
		// obtiene un rowmapper como resultado del query
	}
}
