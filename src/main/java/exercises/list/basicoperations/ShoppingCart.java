package main.java.exercises.list.basicoperations;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    // attribute
    private List<Item> itemList;

    public ShoppingCart() {
        this.itemList = new ArrayList<>();
    }

    public void addItem(String name, double price, int amount){
        Item item = new Item(name, price, amount);
        this.itemList.add(item);
    }

    public void removeItem(String name) {
        List<Item> itemToRemove = new ArrayList<>();
        if (!itemList.isEmpty()) {
            for (Item i : itemList) {
                if (i.getName().equalsIgnoreCase(name)) {
                    itemToRemove.add(i);
                }
            }
            itemList.removeAll(itemToRemove);
        } else {
            System.out.println("The list is empty!!");
        }
    }

    public double calculateTotalValue() {
        double totalvalue = 0;
        if (!itemList.isEmpty()) {
            for (Item item : itemList) {
                double itemValue = item.getPrice() * item.getAmount();
                totalvalue += itemValue;
            }
            return totalvalue;
        } else {
            throw new RuntimeException("The list is empty!!");
        }
    }

    public void displayItems() {
        if (!itemList.isEmpty()) {
            System.out.println(this.itemList);
        } else {
            System.out.println("The list is empty!!");
        }
    }

    @Override
    public String toString() {
        return "ShoppingCart{" +
                "itemList=" + itemList +
                '}';
    }

    public static void main(String[] args) {
        // Creating a shopping cart instance
        ShoppingCart shoppingCart = new ShoppingCart();

        // Adding items to cart
        shoppingCart.addItem("pencil", 2d, 4);
        shoppingCart.addItem("pencil", 2d, 4);
        shoppingCart.addItem("notebook", 29d, 2);
        shoppingCart.addItem("rubber", 2d, 2);

        // Displaying the items in the cart
        shoppingCart.displayItems();

        // Removing an item from the cart
        shoppingCart.removeItem("pencil");

        // Displaying the updated items in the cart
        shoppingCart.displayItems();

        // Calculating and displaying the total purchase amount
        shoppingCart.calculateTotalValue();
    }
}
