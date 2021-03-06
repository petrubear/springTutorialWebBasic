package emg.demos.spring.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import emg.demos.spring.web.dao.IFormValidationGroup;
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

	@RequestMapping("/loggedout")
	public String showLogout() {
		return "loggedout";
	}

	@RequestMapping("/newaccount")
	public String newAccount(Model model) {
		model.addAttribute("user", new User());
		return "newaccount";
	}

	@RequestMapping(value = "/docreateaccount", method = RequestMethod.POST)
	// public String doCreateAccount(Model model, @Valid User user,
	public String doCreateAccount(
			@Validated(IFormValidationGroup.class) User user,
			BindingResult result) {
		if (result.hasErrors()) {
			return "newaccount"; // regresa a creacion si hay un error
		}

		user.setEnabled(true);
		user.setAuthority("ROLE_USER");
		System.out.println(user);

		if (usersService.exists(user.getUsername())) {
			result.rejectValue("username", "DuplicateKey.user.username");
			// ,"This user already exists!");
			// par1 nombre del path del imput que se valida
			// "DuplicateKey.user.username" es un nombre que le doy al
			// constraint

			return "newaccount";
		}
		usersService.create(user);

		// metodo 1 usando exception
		/*
		 * try { usersService.create(user); } catch (DuplicateKeyException e) {
		 * result.rejectValue("username", "DuplicateKey.user.username",
		 * "This user already exists!"); // par1 nombre del path del imput que
		 * se valida //"DuplicateKey.user.username" es un nombre que le doy al
		 * constraint
		 * 
		 * return "newaccount"; }
		 */

		return "accountcreated";
	}

	@RequestMapping("/admin")
	public String showAdmin(Model model) {
		List<User> users = usersService.getAllUsers();
		model.addAttribute("users", users);

		return "admin";
	}

	@RequestMapping("/denied")
	public String showDenied() {
		return "denied";
	}
}
