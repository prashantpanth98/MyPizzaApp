package com.niit.PizzaService.service;

import com.niit.PizzaService.domain.Pizza;
import com.niit.PizzaService.domain.User;
import com.niit.PizzaService.exception.UserAlreadyExistsException;
import com.niit.PizzaService.exception.UserNotFoundException;
import com.niit.PizzaService.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PizzaServiceImpl implements IPizzaService{
    private UserRepository userRepos;
    @Autowired
    PizzaServiceImpl(UserRepository userRepository){ this.userRepos=userRepository;}

    @Override
    public User updatePizzaListOfUser(User user/*, List cartPizzaList*/) throws UserNotFoundException {
        if(userRepos.findById(user.getEmail()).isEmpty()){
            throw new UserNotFoundException();
        }
        //List<Pizza> cartPizzaList=new ArrayList<>();
        //User userReg=userRepos.findById(user.getEmail()).get();
//        Pizza pizza=new Pizza();
//        pizza.setPizzaId(1);
//        pizza.setPizzaName("Mexican");
//        pizza.setPizzaPrice(101.12f);
//        cartPizzaList.add(pizza);
//        userReg.setPizza(cartPizzaList);

        return userRepos.save(user);
    }

    @Override
    public User savePizzaToUserList(Pizza pizza, String email) throws UserNotFoundException{
        if(userRepos.findById(email).isEmpty()){
            throw new UserNotFoundException();
        }
        User userObj=userRepos.findById(email).get();
        if(userObj.getPizza()==null){
            userObj.setPizza(new ArrayList<>());
            userObj.getPizza().add(pizza);
        }
        else{
            userObj.getPizza().add(pizza);
        }
        return userRepos.save(userObj);
    }

    @Override
    public List<Pizza> getAllUserPizzas(String email) throws UserNotFoundException {
        if(userRepos.findById(email).isEmpty()){
            throw new UserNotFoundException();
        }
        List<Pizza> allPizzasList=new ArrayList<>();
        allPizzasList=userRepos.findById(email).get().getPizza();

        return allPizzasList;
    }

    @Override
    public User findUserByEmail(String email) throws UserNotFoundException {
        System.out.println("User'S Email=  "+email);
        Optional<User> user1= userRepos.findById(email);
        User user01=user1.get();
        if(user01==null){
             throw new UserNotFoundException();
        }
        return user01;
    }
    @Override
    public User nullUserPizzaList(String email){
        User user1= userRepos.findById(email).get();

        boolean result= user1.getPizza().removeIf(x->x.getPizzaPrice()>0);

        return userRepos.save(user1);
   }
}
