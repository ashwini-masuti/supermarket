package com.supermarket;

import java.util.TreeMap;

//** This class creates a TreeMap that holds price per item */
public class ItemPriceDetails {

    public static TreeMap<String, Double> itemPrice = new TreeMap<>();

    static{
        itemPrice.put("A",50d);
        itemPrice.put("B",30d);
        itemPrice.put("C",20d);
        itemPrice.put("D",15d);
    }
}
