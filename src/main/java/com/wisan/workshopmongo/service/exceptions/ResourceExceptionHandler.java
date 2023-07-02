package com.wisan.workshopmongo.service.exceptions;

import java.time.Instant;
import java.util.NoSuchElementException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.wisan.workshopmongo.exception.ObjectNotFoundException;

@ControllerAdvice
public class ResourceExceptionHandler {

	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<StandardError> resourceNotFound(ObjectNotFoundException e, HttpServletRequest request) {
		String error = "Resource not found";
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandardError er = new StandardError(Instant.now(), status.value(), error, e.getMessage(),
				request.getRequestURI());
		return ResponseEntity.status(status).body(er);
	}

	@ExceptionHandler(DataIntegrityViolationException.class)
	public ResponseEntity<StandardError> dataIntegrityViolation(DataIntegrityViolationException e,
			HttpServletRequest request) {
		String error = "Data integrity violation";
		HttpStatus status = HttpStatus.BAD_REQUEST;
		StandardError errorResponse = new StandardError(Instant.now(), status.value(), error, e.getMessage(),
				request.getRequestURI());
		return ResponseEntity.status(status).body(errorResponse);
	}

}
