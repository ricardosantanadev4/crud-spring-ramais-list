package br.com.rsds.ramais.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import br.com.rsds.ramais.exception.RecordNotFoundExceptiomn;

@RestControllerAdvice
public class AplicationControllerAdvace {
	@ExceptionHandler
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public String rolaEception(RecordNotFoundExceptiomn ex) {
		return ex.getMessage();
	}
}
