package com.niit.AuthenticationService.service;

import com.niit.AuthenticationService.domain.User;
import com.niit.AuthenticationService.exception.InvalidCredentialsException;
import com.niit.AuthenticationService.exception.UserAlreadyExistsException;
import com.niit.AuthenticationService.exception.UserNotFoundException;
import org.springframework.stereotype.Service;

@Service
public interface IUserService {
    User saveUser(User user) throws UserAlreadyExistsException;
    User loginCheck(String email, String password) throws InvalidCredentialsException;
}
