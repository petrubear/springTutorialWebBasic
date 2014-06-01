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

import emg.demos.spring.web.dao.Offer;
import emg.demos.spring.web.dao.OfferDao;
import emg.demos.spring.web.dao.User;
import emg.demos.spring.web.dao.UsersDao;

@ActiveProfiles("dev")
@ContextConfiguration(locations = {
		"classpath:emg/demos/spring/web/test/config/datasource.xml",
		"classpath:emg/demos/spring/web/config/dao-context.xml",
		"classpath:emg/demos/spring/web/config/security-context.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class OfferDaoTest {

	@Autowired
	private OfferDao offersDao;

	@Autowired
	private UsersDao usersDao;

	@Autowired
	private DataSource dataSource;

	private User user;
	private Offer offer;

	@Before
	public void init() {
		JdbcTemplate jdbc = new JdbcTemplate(dataSource);

		jdbc.execute("delete from offers");
		jdbc.execute("delete from users");
		user = new User("edison", "edison", "edison@emg.com", true,
				"ROLE_ADMINISTRATOR", "Edison");
		offer = new Offer(user, "This is a test offer.");

		assertTrue("User creation should return true", usersDao.create(user));
		assertTrue("Offer creation should return true", offersDao.create(offer));
	}

	@Test
	public void testGetAllOffers() {
		List<Offer> offers = offersDao.getOffers();
		assertEquals("Should be one offer in database.", 1, offers.size());
		// assertEquals("Retrieved offer should match created offer.", offer,
		// offers.get(0));
	}

	@Test
	public void testUpdateOffer() {
		List<Offer> offers = offersDao.getOffers();
		offer.setId(offers.get(0).getId());
		offer.setText("Updated offer text.");
		assertTrue("Offer update should return true", offersDao.update(offer));
	}

	@Test
	public void testGetOfferByUsername() {
		List<Offer> offers = offersDao.getOffer(user.getUsername());

		assertEquals("Must be a user offer", user.getUsername(), offers.get(0)
				.getUser().getUsername());
	}
}
