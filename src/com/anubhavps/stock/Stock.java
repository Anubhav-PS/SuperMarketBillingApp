package com.anubhavps.stock;

import com.anubhavps.products.Products;
import com.anubhavps.supermarket.SuperMarket;

import java.util.ArrayList;
import java.util.Scanner;

public class Stock {

    static ArrayList<Products> productToBeAdded = new ArrayList<>();
    static SuperMarket superMarket = SuperMarket.getInstance();
    static Scanner scanner = new Scanner(System.in);

    public static void displayHeader() {
        System.out.println("__________________________________________________________________");
        System.out.println("**** Enter product name ,price and qty separated by semicolon ****");
        System.out.println("****Enter 'over' after you finish stocking up your storehouse ****");
        System.out.println("__________________________________________________________________");
        System.out.println("Product Name-------Price(Rs)------Qty");
    }

    public static boolean storeProduct() {

        String productDetails = scanner.nextLine();
        String trimmedString = productDetails.trim();
        String[] splitString = trimmedString.split(";");
        if (splitString[0].equalsIgnoreCase("over")) {
            System.out.println("__________________________________________________________________");
            return false;
        }
        String productName = splitString[0];
        float price = Float.parseFloat(splitString[1]);
        int qty = Integer.parseInt(splitString[2]);
        Products product = new Products(productName, price, qty);
        productToBeAdded.add(product);
        return true;

    }

    public static void checkAdd() {
        System.out.println("*****Adding all products in the store house*****");
        for (Products product :
                productToBeAdded) {
            superMarket.addProduct(product);
        }
        productToBeAdded.clear();
    }

    public static void displayAvailableStock() {
        superMarket.displayStock();
    }

    public static void getPrice(String productName) {
        float price = superMarket.getPrice(productName.toLowerCase());
        if (price > 0) {
            System.out.println("The price of " + productName + ", is Rs." + price);
        }
    }

    public static void getStock(String productName) {
        int qty = superMarket.getStock(productName.toLowerCase());
        if (qty > 0) {
            System.out.println(qty + " ,units of " + productName + " is currently available");
        }
    }

    public static void displayProductDetail() {
        String productName = scanner.next();
        superMarket.getProductDetails(productName.toLowerCase());
    }

    public static void removeProduct() {
        String productName = scanner.next();
        superMarket.removeProduct(productName.toLowerCase());
    }

    public static void increaseStock() {
        System.out.println("******Enter the product name and number of new units to be added separated by ';' ******");
        String input = scanner.next();
        input = input.trim();
        String[] product = input.split(";");
        String productName = product[0];
        int qty = Integer.parseInt(product[1]);
        superMarket.increaseStockBy(productName.toLowerCase(), qty);
    }


}
