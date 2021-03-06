package emg.demos.spring.web.dao;

import java.util.List;

import javax.sql.DataSource;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

//import org.springframework.jdbc.core.JdbcTemplate;

@Component("offerDao")
@Transactional
// requerido por hibernate
public class OfferDao {
	// private JdbcTemplate jdbc;
	// private NamedParameterJdbcTemplate jdbc;
	/*
	 * @Autowired public void setDataSource(DataSource jdbc) { // this.jdbc =
	 * new JdbcTemplate(jdbc); this.jdbc = new NamedParameterJdbcTemplate(jdbc);
	 * }
	 */
	@Autowired
	private SessionFactory sessionFactory;

	public Session session() {
		return sessionFactory.getCurrentSession();
	}

	public void saveOrUpdate(Offer offer) {
		session().saveOrUpdate(offer);
	}

	/*
	 * public boolean create(Offer offer) { BeanPropertySqlParameterSource
	 * params = new BeanPropertySqlParameterSource( offer);
	 * 
	 * String sqlQuery =
	 * "insert into offers (username, text) values (:username, :text)";
	 * 
	 * return jdbc.update(sqlQuery, params) == 1; }
	 */
	public void create(Offer offer) {
		session().save(offer);
	}

	// Ejecuta el metodo como una transaccion
	// Se insertan todos los valores de la lista o ninguno
	/*
	 * @Transactional public int[] create(List<Offer> offers) {
	 * SqlParameterSource[] params = SqlParameterSourceUtils
	 * .createBatch(offers.toArray()); String sqlQuery =
	 * "insert into offers (username, text) values (:username, :text)"; return
	 * jdbc.batchUpdate(sqlQuery, params); }
	 */

	// public boolean update(Offer offer) {
	public void update(Offer offer) {
		session().update(offer);
		/*
		 * BeanPropertySqlParameterSource params = new
		 * BeanPropertySqlParameterSource( offer); String sqlQuery =
		 * "update offers set text = :text where id = :id";
		 * 
		 * return jdbc.update(sqlQuery, params) == 1;
		 */
	}

	public boolean delete(int id) {
		Query query = session().createQuery("delete from Offer where id = :id");
		query.setLong("id", id);
		return query.executeUpdate() == 1;
	}

	/*
	 * public boolean delete(int id) { MapSqlParameterSource params = new
	 * MapSqlParameterSource("id", id);
	 * 
	 * return jdbc.update("delete from offers where id = :id", params) == 1; }
	 */

	public List<Offer> getOffer(String username) {
		Criteria criteria = session().createCriteria(Offer.class);
		criteria.createAlias("user", "u");// alias para la otra tabla (users)
		criteria.add(Restrictions.eq("u.enabled", true));
		criteria.add(Restrictions.eq("u.username", username));

		return criteria.list();
		// String sqlString =
		// "select * from offers, users where offers.username=users.username and offers.username = :username";
		// MapSqlParameterSource params = new MapSqlParameterSource();
		// params.addValue("username", username);
		// return jdbc.query(sqlString, params, new OfferRowMapper());

		// queryForObject devuelve 1 valor
		// parametros se definen con : como :name
		/*
		 * return jdbc.queryForObject("select * from offers where id = :id",
		 * params, new RowMapper<Offer>() { public Offer mapRow(ResultSet rs,
		 * int rowNum) throws SQLException { Offer offer = new Offer();
		 * offer.setId(rs.getInt("id")); offer.setName(rs.getString("name"));
		 * offer.setEmail(rs.getString("email"));
		 * offer.setText(rs.getString("text"));
		 * 
		 * return offer; } });
		 */
	}

	public Offer getOffer(int id) {
		Criteria criteria = session().createCriteria(Offer.class);
		criteria.createAlias("user", "u");// alias para la otra tabla (users)
		criteria.add(Restrictions.eq("u.enabled", true));
		criteria.add(Restrictions.idEq(id));

		return (Offer) criteria.uniqueResult();

		/*
		 * MapSqlParameterSource params = new MapSqlParameterSource();
		 * params.addValue("id", id); return jdbc .queryForObject(
		 * "select * from offers, users where offers.username=users.username and id = :id"
		 * , params, new OfferRowMapper());
		 */
		// queryForObject devuelve 1 valor
		// parametros se definen con : como :name
		/*
		 * return jdbc.queryForObject("select * from offers where id = :id",
		 * params, new RowMapper<Offer>() { public Offer mapRow(ResultSet rs,
		 * int rowNum) throws SQLException { Offer offer = new Offer();
		 * offer.setId(rs.getInt("id")); offer.setName(rs.getString("name"));
		 * offer.setEmail(rs.getString("email"));
		 * offer.setText(rs.getString("text"));
		 * 
		 * return offer; } });
		 */
	}

	public List<Offer> getOffers() {
		Criteria criteria = session().createCriteria(Offer.class);
		criteria.createAlias("user", "u");// alias para la otra tabla (users)
		criteria.add(Restrictions.eq("u.enabled", true));

		return criteria.list();
		// String sqlString =
		// "select * from offers, users where offers.username=users.username and users.enabled=true";
		// return jdbc.query(sqlString, new OfferRowMapper());

		/*
		 * return jdbc.query(sqlString, new RowMapper<Offer>() { public Offer
		 * mapRow(ResultSet rs, int rowNum) throws SQLException { User user =
		 * new User(); user.setAuthority(rs.getString("authority"));
		 * user.setEmail(rs.getString("email")); user.setEnabled(true);
		 * user.setName(rs.getString("name"));
		 * user.setUsername(rs.getString("username"));
		 * 
		 * Offer offer = new Offer(); offer.setId(rs.getInt("id"));
		 * offer.setText(rs.getString("text")); offer.setUser(user);
		 * 
		 * return offer; } });
		 */

		/*
		 * return jdbc.query("select * from offers", new RowMapper<Offer>() {
		 * 
		 * public Offer mapRow(ResultSet rs, int rowNum) throws SQLException {
		 * Offer offer = new Offer(); offer.setId(rs.getInt("id"));
		 * offer.setName(rs.getString("name"));
		 * offer.setEmail(rs.getString("email"));
		 * offer.setText(rs.getString("text"));
		 * 
		 * return offer; } });
		 */
	}
}
