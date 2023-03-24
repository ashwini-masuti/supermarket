package com.supermarket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeMap;

public class BufferedInput {
    public static void main(String[] args) throws IOException {
        TreeMap<String, Integer> listOfItems = new TreeMap<>();
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in));
        try{
            System.out.println("Please the add the item to cart : ");
            // Reading data using readLine
            while(true){
                String input = reader.readLine();
                if(input.equalsIgnoreCase("exit")){
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

        }catch(IOException e){
            System.out.println(e);
        }finally {
            reader.close();
        }
    }
}
