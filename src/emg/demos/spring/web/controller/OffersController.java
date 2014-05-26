package emg.demos.spring.web.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

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
	@RequestMapping("/")
	public String showHome(Model model) {
		model.addAttribute("name", "<b>Satou</b>");
		return "home";
	}

}
