package com.example.demo.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(value=AddressBookException.class)
public String userAlreadyExist(AddressBookException addressbookException) {
		return addressbookException.getMessage();
	}
}
