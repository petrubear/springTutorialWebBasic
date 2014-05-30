package emg.demos.spring.web.controller;

import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class CustomErrorHandler {
	// Exceptions
	@ExceptionHandler(DataAccessException.class)
	public ModelAndView handleDatabaseException(DataAccessException exception) {
		ModelAndView mv = new ModelAndView("error");
		Map<String, Object> model = mv.getModel();
		model.put("description", exception.getMessage());
		return mv;
	}

	@ExceptionHandler(AccessDeniedException.class)
	public String handleAccessDeniedException(AccessDeniedException exception) {
		return "denied";
	}
}
