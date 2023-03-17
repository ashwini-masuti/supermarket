package com.supermarket;

import java.io.IOException;
import java.util.TreeMap;

public class PayNowForShopping {

    public static void main(String[] args) throws IOException {
        TreeMap<String, Integer> listOfItems = new TreeMap<>();

        for(String s : args){
            if(!listOfItems.containsKey(s)){
                listOfItems.put(s,1);
                System.out.println(s + " Item is added to cart");
                System.out.println("Running price till now is : "+CheckoutKart.calculateTotalPrice(listOfItems));
            }else{
                Integer count = listOfItems.get(s)+1;
                System.out.println(count + " quantity of " + s + " are added to Shopping cart");
                listOfItems.put(s, count);
                System.out.println("Running price till now is : "+CheckoutKart.calculateTotalPrice(listOfItems));
            }
        }

        System.out.println("Total price of cart is : "+CheckoutKart.calculateTotalPrice(listOfItems));
        CheckoutKart.showItemsInShoppingCart(listOfItems);


    }

}
