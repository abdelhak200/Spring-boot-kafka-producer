package ch.flashcode.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class BeanBadRequestException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public BeanBadRequestException(String message) {
		super(message);
	}
}