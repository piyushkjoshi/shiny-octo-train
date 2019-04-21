package com.pramati.test.exception;

import java.util.Date;
import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;




@ControllerAdvice
@RestController
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<ExceptionResponse> handleAllExceptions(Exception ex, WebRequest request) {
		ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), ex.getMessage(),
				request.getDescription(false));
		return new ResponseEntity<>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(CityNotFoundException.class)
	public final ResponseEntity<ExceptionResponse> handleNotFoundException(CityNotFoundException ex,
			WebRequest request) {
		ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), ex.getMessage(),
				request.getDescription(false));
		return new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_FOUND);
	}
	

	
	@ExceptionHandler(ConstraintViolationException.class)
	   protected ResponseEntity<?> handleConstraintViolationException(ConstraintViolationException ex, WebRequest request) {
	    try {
	     ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), ex.getMessage(),
					request.getDescription(false));
	     
	     return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
	    } catch (Exception e) {
	     return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	   }
	
	@Override
	  protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
	      HttpHeaders headers, HttpStatus status, WebRequest request) {
	    ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), "Validation Failed",
	        ex.getBindingResult().toString());
	    return new ResponseEntity(exceptionResponse, HttpStatus.BAD_REQUEST);
	  } 

}