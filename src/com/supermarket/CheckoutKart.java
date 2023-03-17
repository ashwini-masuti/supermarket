package com.supermarket;

import java.util.Set;
import java.util.TreeMap;


public class CheckoutKart {

    public static TreeMap<String, Integer> itemsListMap = new TreeMap<>();

    public static void showItemsInShoppingCart(TreeMap<String,Integer> listOfItems){
       if(listOfItems.isEmpty())
            throw new ItemException("Your cart is empty");

        Set<String> listOfItem = listOfItems.keySet();
        for(String s : listOfItem){
            System.out.println("Item : "+ s + " Quantity : "+listOfItems.get(s));
        }
    }

    //** Method to add items to shopping cart*/
    public static void addItem(String item, Integer quantity){
        //if item doesnt exist in list then add it, if exist update the quantity
        if(!itemsListMap.containsKey(item)){
            itemsListMap.put(item,quantity);
        }else{
            itemsListMap.replace(item, quantity);
        }
    }

    public static void removeItem(String item, Integer quantityTobeRemoved){
        if(!itemsListMap.containsKey(item))
            throw new ItemException("Item does not exist in your shopping cart. Please recheck");

        if(itemsListMap.get(item) == quantityTobeRemoved){
            itemsListMap.remove(item);
        }else if(itemsListMap.get(item) > quantityTobeRemoved){
            itemsListMap.replace(item,itemsListMap.get(item) - quantityTobeRemoved);
        }else
            throw new ItemException("Quantity to be removed is more than quantity selected in cart");
    }

    public static void emptyCart(){
        itemsListMap.clear();
    }

    public static double calculateTotalPrice(TreeMap<String,Integer> listOfItems){
        if(listOfItems.isEmpty()){
            throw new ItemException("Cart is empty");
        }

        Double totalPrice = 0.0;

        Set<String> keys = listOfItems.keySet();

        for(String item : keys){
            Integer totalQty = listOfItems.get(item);


            if(ItemOfferDetails.itemOfferDetailsTreeMap.containsKey(item)){
                ItemSpecialOffers existingOffer = ItemOfferDetails.itemOfferDetailsTreeMap.get(item);

                if(existingOffer.quantity < totalQty){
                    totalPrice += (totalQty % existingOffer.quantity) * ItemPriceDetails.itemPrice.get(item)
                                + (totalQty / existingOffer.quantity) * ItemOfferDetails.itemOfferDetailsTreeMap.get(item).price;
                }else if(existingOffer.quantity == totalQty){
                    totalPrice += ItemOfferDetails.itemOfferDetailsTreeMap.get(item).price;
                }else{
                    totalPrice += totalQty * ItemPriceDetails.itemPrice.get(item);
                }
            }else{
                totalPrice += totalQty * ItemPriceDetails.itemPrice.get(item);
            }
        }
        return totalPrice;
    }

}

