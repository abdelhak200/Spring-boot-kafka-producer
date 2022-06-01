package ch.flashcode.producer.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import ch.flashcode.exception.BeanBadRequestException;
import ch.flashcode.exception.BeanNotFoundException;

@RestControllerAdvice
public class ControllerAdvice {

	@ExceptionHandler(value = BeanBadRequestException.class)
	public final Map<String, HttpStatus> handleAllExceptions(BeanBadRequestException ex) {
		Map<String, HttpStatus> response = new HashMap<>();
		response.put("status", HttpStatus.BAD_REQUEST);

		return response;
	}

	@ExceptionHandler(value = BeanNotFoundException.class)
	public final Map<String, HttpStatus> handleUserNotFoundException(BeanNotFoundException ex) {
		Map<String, HttpStatus> response = new HashMap<>();
		response.put("status", HttpStatus.NOT_FOUND);

		return response;
	}
	
	/*
	 * @ExceptionHandler(BeanNotFoundException.class)
	 * 
	 * @ResponseStatus(HttpStatus.NOT_FOUND) public Map<String, HttpStatus>
	 * handleItemNotFoundException(Exception exception) {
	 * 
	 * Map<String, HttpStatus> response = new HashMap<>(); response.put("status",
	 * HttpStatus.NOT_FOUND);
	 * 
	 * return response; }
	 * 
	 * @ExceptionHandler(BeanBadRequestException.class)
	 * 
	 * @ResponseStatus(HttpStatus.BAD_REQUEST) public Map<String, HttpStatus>
	 * handleMethodArgumentNotValid(Exception ex) { Map<String, HttpStatus> response
	 * = new HashMap<>(); response.put("status", HttpStatus.BAD_REQUEST);
	 * 
	 * return response; }
	 */
}
