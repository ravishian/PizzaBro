package com.soni5.pizzabro.Model;

public class HomeModel

{
    String Description , NamePizza , Number , Price , id;

    public HomeModel() {
    }

    public HomeModel(String description, String namePizza, String number, String price, String id) {
        Description = description;
        NamePizza = namePizza;
        Number = number;
        Price = price;
        this.id = id;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getNamePizza() {
        return NamePizza;
    }

    public void setNamePizza(String namePizza) {
        NamePizza = namePizza;
    }

    public String getNumber() {
        return Number;
    }

    public void setNumber(String number) {
        Number = number;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
