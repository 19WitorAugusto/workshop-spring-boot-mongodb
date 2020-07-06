package com.witoraugusto.worckshopMongo.resources.exception;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.witoraugusto.worckshopMongo.services.exception.ObjectNotFoundException;

@ControllerAdvice // tratar possiveis erros em exercuções
public class ResourceExceptionHandler {

	// manipulador de excerções

	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<StandardError> ObjectNotFoundEx(ObjectNotFoundException e, HttpServletRequest request) {

		HttpStatus status = HttpStatus.NOT_FOUND;
		StandardError err = new StandardError(Instant.now(), status.value(), "Não encontrado!", e.getMessage(),
				request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}
}
