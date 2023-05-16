package br.com.rsds.ramaislist.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import br.com.rsds.ramaislist.exception.RecordNotFoundExceptiomn;

@RestControllerAdvice
public class AplicationControllerAdvace {
	@ExceptionHandler
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public String rolaEception(RecordNotFoundExceptiomn ex) {
		return ex.getMessage();
	}
}
