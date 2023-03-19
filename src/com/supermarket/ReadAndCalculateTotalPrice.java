package com.supermarket;

import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.TreeMap;

public class ReadAndCalculateTotalPrice {

    public static void main(String[] args) {
        TreeMap<String, Integer> listOfItems = new TreeMap<>();
        Scanner scanner =  new Scanner(new InputStreamReader(System.in));
        while(true){
            System.out.println("Please the add the item to cart : ");
            String input = scanner.next();
            if("exit".equalsIgnoreCase(input)){
                System.out.println("Thanks for shopping with us");
                break;
            }
            if(ItemPriceDetails.itemPrice.containsKey(input)){
                if(!listOfItems.containsKey(input)){
                    listOfItems.put(input,1);
                    System.out.println(input + " Item is added to cart");
                    System.out.println("Running price till now is : "+CheckoutKart.calculateTotalPrice(listOfItems));
                }else{
                    Integer count = listOfItems.get(input)+1;
                    System.out.println(count + " quantity of " + input + " are added to Shopping cart");
                    listOfItems.put(input, count);
                    System.out.println("Running price till now is : "+CheckoutKart.calculateTotalPrice(listOfItems));
                }
            }else{
                throw new ItemException("Invalid Item added to cart");
            }
            System.out.println("Total price of cart is : "+CheckoutKart.calculateTotalPrice(listOfItems));
            CheckoutKart.showItemsInShoppingCart(listOfItems);
        }
    }
}
