package com.supermarket;

import java.util.TreeMap;

//** This class creates a TreeMap that holds special offers in supermarket for given item */
public class ItemOfferDetails {
    public static TreeMap<String, ItemSpecialOffers> itemOfferDetailsTreeMap
            = new TreeMap<>();

    static{
        itemOfferDetailsTreeMap.put("A",new ItemSpecialOffers("A",3,130d));
        itemOfferDetailsTreeMap.put("B",new ItemSpecialOffers("B",2,45d));
    }

}
