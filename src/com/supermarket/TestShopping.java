package com.supermarket;

import org.junit.Assert;
import org.junit.Test;
import java.util.TreeMap;

/** Junit to test the 2 different scenarios */
public class TestShopping {

    @Test
    public void ShopItemsABCWithoutOffer(){
        TreeMap<String, Integer> listOfItems = new TreeMap<>();
        listOfItems.put("A",2);
        listOfItems.put("B",1);
        listOfItems.put("C",1);
        double totalPrice = CheckoutKart.calculateTotalPrice(listOfItems);
        Assert.assertEquals(150,totalPrice,0);
    }

    @Test
    public void ShopItemsABCDWithoutOffer(){
        TreeMap<String, Integer> listOfItems = new TreeMap<>();
        listOfItems.put("A",1);
        listOfItems.put("B",1);
        listOfItems.put("C",1);
        listOfItems.put("D",1);
        double totalPrice = CheckoutKart.calculateTotalPrice(listOfItems);
        Assert.assertEquals(115,totalPrice,0);
    }
    @Test
    public void ShopItemsABCDWithOffer(){
        TreeMap<String, Integer> listOfItems = new TreeMap<>();
        listOfItems.put("A",5);
        listOfItems.put("B",4);
        listOfItems.put("C",5);
        listOfItems.put("D",2);
        double totalPrice = CheckoutKart.calculateTotalPrice(listOfItems);
        Assert.assertEquals(450,totalPrice,0);
    }

}
