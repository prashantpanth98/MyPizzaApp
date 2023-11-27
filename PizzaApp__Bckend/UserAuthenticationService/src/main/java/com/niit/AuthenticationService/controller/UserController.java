package com.niit.AuthenticationService.controller;

import com.niit.AuthenticationService.domain.User;
import com.niit.AuthenticationService.exception.InvalidCredentialsException;
import com.niit.AuthenticationService.exception.UserAlreadyExistsException;
import com.niit.AuthenticationService.exception.UserNotFoundException;
import com.niit.AuthenticationService.security.SecurityTokenGeneratorImpl;
import com.niit.AuthenticationService.service.UserServiceImpl;
//import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("api/v1")
@CrossOrigin(origins = "http://localhost:4200/")
public class UserController {
    UserServiceImpl userService;
    SecurityTokenGeneratorImpl sTGenerator;
    ResponseEntity<?> responseEntity;

    @Autowired
    UserController(UserServiceImpl userService, SecurityTokenGeneratorImpl sTGenerator){
        this.userService=userService;
        this.sTGenerator=sTGenerator;
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody User user) throws UserAlreadyExistsException{
        try{
            responseEntity= new ResponseEntity<>(userService.saveUser(user), HttpStatus.CREATED);
        }
        catch (UserAlreadyExistsException e){ throw new UserAlreadyExistsException(); }
        return responseEntity;
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody User user) throws InvalidCredentialsException{
        try{
            User getLoginUser=userService.loginCheck(user.getEmail(), user.getPassword());
            if(getLoginUser!=null){
                Map<String,String> token=sTGenerator.tokenGenerator(user);
                responseEntity=new ResponseEntity<>(token,HttpStatus.OK);
            }
        }
        catch (InvalidCredentialsException e){ throw new InvalidCredentialsException(); }
        return responseEntity;
    }
}
