package com.niit.PizzaService.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND,reason = "User does not Exists!")
public class UserNotFoundException extends Exception {
}
