package emg.demos.spring.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import emg.demos.spring.web.dao.Offer;
import emg.demos.spring.web.dao.OfferDAO;

@Service("offersService")
public class OffersService {
	private OfferDAO offerDao;

	public List<Offer> getCurrent() {
		return offerDao.getOffers();
	}

	@Autowired
	public void setOfferDao(OfferDAO offerDao) {
		this.offerDao = offerDao;
	}

}
