package com.web.exceptionhandling;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * Form input validation exception handler of Spring Boot
 * 
 * @author Muhammad Tariq
 *
 */
@ControllerAdvice
public class ValidationExceptionHandler extends ResponseEntityExceptionHandler {
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {

		BindingResult bindingResult = ex.getBindingResult();
		List<Object> errorResponse = new ArrayList<>();
		for (FieldError fieldError : bindingResult.getFieldErrors()) {
			Map<String, Object> error = new HashMap<>();
			error.put("Field", fieldError.getField());
			error.put("Rejected Value", fieldError.getRejectedValue());
			error.put("Default Message", fieldError.getDefaultMessage());
			errorResponse.add(error);
		}
		ErrorDetails errorDetails = new ErrorDetails(new Date(), "Validation Failed", bindingResult.getErrorCount(),
				errorResponse);
		return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
	}
}
