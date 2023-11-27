package com.niit.AuthenticationService.repository;

import com.niit.AuthenticationService.domain.User;
import com.niit.AuthenticationService.exception.InvalidCredentialsException;
import com.niit.AuthenticationService.exception.UserNotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,String> {
    User findUserByEmailAndPassword(String email, String password) throws InvalidCredentialsException;
    //User findUserByEmail(String email) throws UserNotFoundException;
}
