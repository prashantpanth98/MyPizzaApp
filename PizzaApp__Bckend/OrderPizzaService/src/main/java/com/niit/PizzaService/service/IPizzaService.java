package com.niit.PizzaService.service;

import com.niit.PizzaService.domain.Pizza;
import com.niit.PizzaService.domain.User;
import com.niit.PizzaService.exception.UserAlreadyExistsException;
import com.niit.PizzaService.exception.UserNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IPizzaService {
    User updatePizzaListOfUser(User user/*, List prePizzaList*/) throws  UserNotFoundException;
    User savePizzaToUserList(Pizza pizza, String email) throws UserNotFoundException;
    List<Pizza> getAllUserPizzas(String email) throws UserNotFoundException;
    User findUserByEmail(String email) throws UserNotFoundException;
    User nullUserPizzaList(String email);
}
