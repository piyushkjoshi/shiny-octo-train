package com.pramati.test.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolationException;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(Exception.class)
	public final String handleAllExceptions(Exception ex, HttpServletRequest request,HttpServletResponse response) {
		response.setStatus(500);
		return "Internal server error";
	}

	@ExceptionHandler(CityNotFoundException.class)
	public final String handleNotFoundException(CityNotFoundException ex, HttpServletRequest request,HttpServletResponse response) {
		response.setStatus(404);
		return "Not Found";
	}

	@ExceptionHandler(ConstraintViolationException.class)
	protected String handleConstraintViolationException(ConstraintViolationException ex, HttpServletRequest request,HttpServletResponse response) {
	
		response.setStatus(400);
		return ex.getMessage();

	}

}