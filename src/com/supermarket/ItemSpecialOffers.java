package com.supermarket;

//** This class defines item which can have offers*/
public class ItemSpecialOffers {

    public String name;
    public Integer quantity;
    public Double price;

    public ItemSpecialOffers(String n, Integer qty, Double p){
        name = n;
        quantity = qty;
        price = p;
    }
}
