package com.niit.PizzaService.domain;

import org.springframework.data.annotation.Id;

public class Pizza{
    @Id
    private int pizzaId;
    private String pizzaName;
    private float pizzaPrice;

    public Pizza() {}

    public Pizza(int pizzaId,String pizzaName, float pizzaPrice) {
        this.pizzaId=pizzaId;
        this.pizzaName = pizzaName;
        this.pizzaPrice = pizzaPrice;
    }

    public int getPizzaId() {
        return pizzaId;
    }
    public void setPizzaId(int pizzaId) {
        this.pizzaId = pizzaId;
    }

    public String getPizzaName() {
        return pizzaName;
    }
    public void setPizzaName(String pizzaName) {
        this.pizzaName = pizzaName;
    }

    public float getPizzaPrice() {
        return pizzaPrice;
    }
    public void setPizzaPrice(float pizzaPrice) {
        this.pizzaPrice = pizzaPrice;
    }

    @Override
    public String toString() {
        return "Pizza{" +
                "pizzaId=" + pizzaId +
                ", pizzaName='" + pizzaName + '\'' +
                ", pizzaPrice=" + pizzaPrice +
                '}';
    }
}
