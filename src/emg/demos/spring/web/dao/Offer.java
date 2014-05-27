package emg.demos.spring.web.dao;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class Offer {

	private int id;
	@Size(min = 5, max = 20, message = "[name] Debe ser de tamaño 5 - 20!")
	// validaciones (hibernate validation)
	private String name;
	@Pattern(regexp=".*\\@.*\\..*", message="Ingrese un email valido")
	@NotNull
	private String email;
	@Size(min = 5, max = 100, message = "[text] Debe ser de tamaño 5 - 100!")
	private String text;

	public Offer() {
		super();
	}

	public Offer(String name, String email, String text) {
		super();
		this.name = name;
		this.email = email;
		this.text = text;
	}

	public Offer(int id, String name, String email, String text) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.text = text;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	@Override
	public String toString() {
		return "Offer [id=" + id + ", name=" + name + ", email=" + email
				+ ", text=" + text + "]";
	}

}
