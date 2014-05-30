package emg.demos.spring.web.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

//import org.springframework.jdbc.core.JdbcTemplate;

@Component("usersDao")
public class UsersDao {
	// private JdbcTemplate jdbc;
	private NamedParameterJdbcTemplate jdbc;
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	public void setDataSource(DataSource jdbc) {
		// this.jdbc = new JdbcTemplate(jdbc);
		this.jdbc = new NamedParameterJdbcTemplate(jdbc);
	}

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

		String sqlQuery = "insert into `users` (`username`, `password`, `email`) values (:username,:password,:email);";
		String sqlQuery2 = "insert into `authorities` (`username`, `authority`) values (:username,:authority);";
		jdbc.update(sqlQuery, params);
		return jdbc.update(sqlQuery2, params) == 1;
	}

	public boolean exists(String username) {
		return jdbc.queryForObject(
				"select count(*) from `users` where `username` = :username;",
				new MapSqlParameterSource("username", username), Integer.class) > 0;
	}

	public List<User> getAllUsers() {
		return jdbc
				.query("SELECT * FROM users, authorities WHERE users.username = authorities.username",
						BeanPropertyRowMapper.newInstance(User.class)); // obtiene
																		// un
																		// rowmaper
																		// con
																		// el
																		// resultado
	}
}
