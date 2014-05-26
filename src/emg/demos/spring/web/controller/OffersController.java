package emg.demos.spring.web.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

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

	@RequestMapping("/")
	public String showHome(Model model) {
		List<Offer> offers = offersService.getCurrent();

		model.addAttribute("name", "<b>Satou</b>");
		model.addAttribute("offers", offers);
		return "home";
	}

	@Autowired
	public void setOffersService(OffersService offersService) {
		this.offersService = offersService;
	}

}
