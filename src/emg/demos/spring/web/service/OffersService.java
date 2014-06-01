package emg.demos.spring.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;

import emg.demos.spring.web.dao.Offer;
import emg.demos.spring.web.dao.OfferDao;

@Service("offersService")
public class OffersService {
	private OfferDao offerDao;

	public List<Offer> getCurrent() {
		return offerDao.getOffers();
	}

	@Autowired
	public void setOfferDao(OfferDao offerDao) {
		this.offerDao = offerDao;
	}

	@Secured({ "ROLE_USER", "ROLE_ADMIN" })
	public void create(Offer offer) {
		this.offerDao.create(offer);
	}

	public void throwExceptionTest() {
		this.offerDao.getOffer(9000000);
	}

	public boolean hasOffer(String name) {
		if (name == null)
			return false;
		return offerDao.getOffer(name).size() > 0;
	}

	public List<Offer> getOffers(String username) {
		if (username == null)
			return null;
		return offerDao.getOffer(username);
	}

	public void saveOrUpdate(Offer offer) {
		if (offer.getId() != 0) {
			offerDao.update(offer);
		} else {
			offerDao.create(offer);
		}
	}

	public void delete(int id) {
		offerDao.delete(id);
	}
}
