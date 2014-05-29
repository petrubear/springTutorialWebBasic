package emg.demos.spring.web.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import emg.demos.spring.web.dao.User;
import emg.demos.spring.web.service.UsersService;

@Controller
public class LoginController {
	private UsersService usersService;

	@Autowired
	public void setUsersService(UsersService usersService) {
		this.usersService = usersService;
	}

	@RequestMapping("/login")
	public String showLogin() {
		return "login";
	}

	@RequestMapping("/newaccount")
	public String newAccount(Model model) {
		model.addAttribute("user", new User());
		return "newaccount";
	}

	@RequestMapping(value = "/docreateaccount", method = RequestMethod.POST)
	public String doCreateAccount(Model model, @Valid User user,
			BindingResult result) {
		System.out.println(user);
		if (result.hasErrors()) {
			return "newaccount"; // regresa a creacion si hay un error
		}

		user.setEnabled(true);
		user.setAuthority("user");
		
		usersService.create(user);
		return "accountcreated";
	}
}
