package emg.demos.spring.web.controller;

import java.security.Principal;
import java.util.List;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import emg.demos.spring.web.dao.IFormValidationGroup;
import emg.demos.spring.web.dao.Offer;
import emg.demos.spring.web.service.OffersService;

@Controller
public class OffersController {
	/*
	 * Opcion 1 usando ModelAndView
	 * 
	 * @RequestMapping("/") public ModelAndView showHome() {// String showHome
	 * (HttpSession session) { // session.setAttribute("name", "Boris");
	 * ModelAndView mv = new ModelAndView("home"); Map<String, Object> model =
	 * mv.getModel(); model.put("name", "Natasha"); // return "home"; return mv;
	 * }
	 */
	/* opcion 2 usando Spring Model */

	private static Logger logger = Logger.getLogger(OffersController.class);
	private OffersService offersService;

	@RequestMapping("/offers")
	public String showOffers(Model model) {
		// offersService.throwExceptionTest();
		List<Offer> offers = offersService.getCurrent();

		model.addAttribute("name", "<b>Satou</b>");
		model.addAttribute("offers", offers);
		return "offers";
	}

	@RequestMapping("/createoffer")
	public String createOffer(Model model, Principal principal) {
		Offer offer = new Offer();
		if (principal != null) {
			String username = principal.getName();
			logger.debug("Principal: " + username);
			List<Offer> offers = offersService.getOffers(username);
			logger.debug("Principal Offers: " + offers.size());
			if (offers.size() > 0) {
				offer = offers.get(0);
			}
		}
		model.addAttribute("offer", offer);
		return "createoffer";
	}

	@RequestMapping(value = "/docreate", method = RequestMethod.POST)
	// public String doCreate(Model model, @Valid Offer offer,
	public String doCreate(@Validated(IFormValidationGroup.class) Offer offer,
			BindingResult result, Principal principal,
			@RequestParam(value = "delete", required = false) String delete) {
		logger.debug(offer);
		if (result.hasErrors()) {
			return "createoffer"; // regresa a creacion si hay un error
		}

		if (delete == null) {
			String username = principal.getName();
			offer.getUser().setUsername(username);
			offersService.saveOrUpdate(offer);
		} else {
			offersService.delete(offer.getId());
		}

		return "offercreated";
	}

	@Autowired
	public void setOffersService(OffersService offersService) {
		this.offersService = offersService;
	}

	// Exceptions
	/*
	 * @ExceptionHandler(DataAccessException.class) public String
	 * handleDatabaseException(DataAccessException exception) { return "error";
	 * }
	 */
}
