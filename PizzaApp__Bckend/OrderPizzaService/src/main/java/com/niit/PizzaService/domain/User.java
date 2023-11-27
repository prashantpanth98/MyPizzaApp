package com.niit.PizzaService.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import com.niit.PizzaService.domain.Pizza;

import java.util.List;

@Document
public class User {
    @Id
    private String email;
    private String password;
    private String userName;
    private String phoneNo;
    private List<Pizza> pizza;

    public User() {}

    public User(String email, String password, String userName, String phoneNo, List<Pizza> pizza) {
        this.email = email;
        this.password = password;
        this.userName = userName;
        this.phoneNo = phoneNo;
        this.pizza = pizza;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPhoneNo() {
        return phoneNo;
    }
    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public List<Pizza> getPizza() {
        return pizza;
    }
    public void setPizza(List<Pizza> pizza) {
        this.pizza = pizza;
    }

    @Override
    public String toString() {
        return "User{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", userName='" + userName + '\'' +
                ", phoneNo='" + phoneNo + '\'' +
                ", pizza=" + pizza +
                '}';
    }
}
