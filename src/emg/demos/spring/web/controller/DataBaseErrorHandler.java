package emg.demos.spring.web.controller;

import org.springframework.dao.DataAccessException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class DataBaseErrorHandler {
	// Exceptions
	@ExceptionHandler(DataAccessException.class)
	public String handleDatabaseException(DataAccessException exception) {
		return "error";
	}
}
