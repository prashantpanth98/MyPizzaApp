package com.niit.AuthenticationService.service;

import com.niit.AuthenticationService.exception.UserNotFoundException;
import com.niit.AuthenticationService.repository.UserRepository;
import com.niit.AuthenticationService.domain.User;
import com.niit.AuthenticationService.exception.InvalidCredentialsException;
import com.niit.AuthenticationService.exception.UserAlreadyExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService{
    UserRepository userRepository;
    @Autowired
    UserServiceImpl(UserRepository userRepository){ this.userRepository=userRepository; }

    @Override
    public User saveUser(User user) throws UserAlreadyExistsException {
        if(userRepository.findById(user.getEmail()).isPresent()){
            throw new UserAlreadyExistsException();
        }
        System.out.println(user);
        return userRepository.save(user);
    }

    @Override
    public User loginCheck(String email, String password) throws InvalidCredentialsException {
        System.out.println("Email: "+email);
        System.out.println("Password: "+password);
        User loggedInUser=userRepository.findUserByEmailAndPassword(email,password);
        if(loggedInUser==null){
            throw new InvalidCredentialsException();
        }
        return loggedInUser;
    }
}

