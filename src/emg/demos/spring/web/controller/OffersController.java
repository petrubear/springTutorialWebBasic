package emg.demos.spring.web.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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

	private OffersService offersService;

	@RequestMapping("/offers")
	public String showOffers(Model model) {
		List<Offer> offers = offersService.getCurrent();

		model.addAttribute("name", "<b>Satou</b>");
		model.addAttribute("offers", offers);
		return "offers";
	}

	@RequestMapping("/createoffer")
	public String createOffer(Model model) {
		model.addAttribute("offer", new Offer());
		return "createoffer";
	}

	@RequestMapping(value = "/docreate", method = RequestMethod.POST)
	public String doCreate(Model model, @Valid Offer offer, BindingResult result) {
		System.out.println(offer);
		if (result.hasErrors()) {
			return "createoffer"; // regresa a creacion si hay un error
		}
		return "offercreated";
	}

	@Autowired
	public void setOffersService(OffersService offersService) {
		this.offersService = offersService;
	}

}
