package com.niit.PizzaService.controller;

import com.niit.PizzaService.domain.Pizza;
import com.niit.PizzaService.domain.User;
import com.niit.PizzaService.exception.UserAlreadyExistsException;
import com.niit.PizzaService.exception.UserNotFoundException;
import com.niit.PizzaService.service.PizzaServiceImpl;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("api/v2")
@CrossOrigin(origins = "http://localhost:4200/")
public class PizzaController {
    private PizzaServiceImpl pizzaService;
    private ResponseEntity<?> responseEntity;

    @Autowired
    PizzaController(PizzaServiceImpl pizzaService){ this.pizzaService=pizzaService; }

    @PostMapping("/update")
    public ResponseEntity<?> saveUserPizzaList(@RequestBody User user/*, List cartPizzaList*/) throws UserNotFoundException{
        try{
            responseEntity= new ResponseEntity<>(pizzaService.updatePizzaListOfUser(user), HttpStatus.OK);
        }
        catch (UserNotFoundException e){ throw new UserNotFoundException(); }
        return responseEntity;
    }

    @PostMapping("/aUser/{mail}")
    public ResponseEntity<?> addPizzaToUserOrderList(@RequestBody Pizza pizza,@PathVariable String email,
            HttpServletRequest request) throws UserNotFoundException
    {
        try{
            System.out.println("header"+ request.getHeader("Authorization"));
            Claims claims=(Claims) request.getAttribute("userName");
            System.out.println("User Email from Claims :: "+claims.getSubject());
            String emailId=claims.getSubject();
            System.out.println("email :: "+emailId);
            responseEntity= new ResponseEntity<>(pizzaService.savePizzaToUserList(pizza,email),HttpStatus.CREATED);
        }
        catch (UserNotFoundException e){ throw new UserNotFoundException(); }
        return responseEntity;
    }

    @GetMapping("/aUser/{mail}")
    public ResponseEntity<?> getAllUserOrderedPizzas(@PathVariable String mail, HttpServletRequest request) throws UserNotFoundException{
        try{
            System.out.println("header: "+ request.getHeader("Authorization"));
            Claims claims=(Claims) request.getAttribute("userName");
            String emailId=claims.getSubject();
            System.out.println("email ::"+emailId);
            responseEntity=new ResponseEntity<>(pizzaService.getAllUserPizzas(emailId),HttpStatus.FOUND);
        }
        catch (UserNotFoundException e) { throw new UserNotFoundException(); }
        return responseEntity;
    }

    @GetMapping("/user/{email}")
    public ResponseEntity<?> findUserViaEmail(@PathVariable String email/*, HttpServletRequest request*/) throws UserNotFoundException{
       //System.out.println("USEr Email= "+email);
        try{
//            System.out.println("header: "+ request.getHeader("Authorization"));
//            Claims claims=(Claims) request.getAttribute("claims");
//            System.out.println("email from claims :: " + claims.getSubject());
//            String emailId= claims.getSubject();
//            System.out.println("email ::"+emailId);
            responseEntity=new ResponseEntity<>(pizzaService.findUserByEmail(email),HttpStatus.OK);
        }
        catch (UserNotFoundException e){ throw new UserNotFoundException(); }
        return responseEntity;
    }

    @PutMapping("delUser/{email}")
    public ResponseEntity<?> nullUserPizzaListViaEmail(@PathVariable String email/*, HttpServletRequest request*/){
        return new ResponseEntity<>(pizzaService. nullUserPizzaList(email),HttpStatus.OK);
    }
}
