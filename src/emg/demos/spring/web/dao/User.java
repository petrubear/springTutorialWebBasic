package emg.demos.spring.web.dao;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

import emg.demos.spring.web.validation.CustomEmailValidator;

public class User {

	@Size(min = 4, max = 15, message = "invalid username, must be 4-15")
	@NotBlank(message = "username is required")
	@Pattern(regexp = "^\\w{4,}$", message = "invalid username must be alphanumeric")
	private String username;
	@Size(min = 4, max = 15, message = "invalid password, must be 4-15")
	@NotBlank(message = "password is required")
	@Pattern(regexp = "^\\S+$", message = "invalid password, must not have spaces")
	private String password;
	@Size(min = 10, max = 60)
	@CustomEmailValidator
	@NotBlank(message = "email is required")
	private String email;
	private boolean enabled = false;
	private String authority;

	public User() {

	}

	public User(String username, String password, String email,
			boolean enabled, String authority) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
		this.enabled = enabled;
		this.authority = authority;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

}
