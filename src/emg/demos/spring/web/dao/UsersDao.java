package emg.demos.spring.web.dao;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

//import org.springframework.jdbc.core.JdbcTemplate;

@Component("usersDao")
public class UsersDao {
	// private JdbcTemplate jdbc;
	private NamedParameterJdbcTemplate jdbc;

	@Autowired
	public void setDataSource(DataSource jdbc) {
		// this.jdbc = new JdbcTemplate(jdbc);
		this.jdbc = new NamedParameterJdbcTemplate(jdbc);
	}

	public boolean create(User user) {
		BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(
				user);

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
}
