package Bookstore.exception;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<?> handleResourceNotFound(ResourceNotFoundException ex){
		return buildErrorResponse(ex.getMessage(),HttpStatus.NOT_FOUND);
	}

	private ResponseEntity<?> buildErrorResponse(String message, HttpStatus status) {
		   Map<String, Object> body = new HashMap<>();
	        body.put("timestamp", LocalDateTime.now());
	        body.put("status", status.value());
	        body.put("error", status.getReasonPhrase());
	        body.put("message", message);
	        return new ResponseEntity<>(body, status);
	    }
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> handleGenericException(Exception ex){
		return buildErrorResponse("Internal Server Error : "+ex.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
