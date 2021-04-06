package com.anubhavps.billing;

import com.anubhavps.person.Customer;
import com.anubhavps.supermarket.SuperMarket;

import java.util.ArrayList;
import java.util.Scanner;

public class ProcessBill {

    static Scanner scanner = new Scanner(System.in);
    static Customer customerDetail;
    static ArrayList<Order> orders = new ArrayList<>();

    public static void displayHeader() {
        System.out.println("__________________________________________________________________");
        System.out.println("**** Enter product name and units separated by semicolon ****");
        System.out.println("****Enter 'over' after you finish stocking up your storehouse ****");
        System.out.println("__________________________________________________________________");
        System.out.println("Product Name-------Units");
    }

    public static boolean takeInOrders(Customer customer) {
        customerDetail = customer;
        String productDetails = scanner.nextLine();
        String trimmedString = productDetails.trim();
        String[] splitString = trimmedString.split(";");
        if (splitString[0].equalsIgnoreCase("over")) {
            System.out.println("__________________________________________________________________");
            return false;
        }
        String productName = splitString[0];
        int qty = Integer.parseInt(splitString[1]);
        Order order = new Order(productName, qty);
        if (!orders.contains(order)) {
            orders.add(order);
        }
        return true;
    }

    public static void checkAndProcess() {
        float totalPurchase = 0;
        System.out.println("_______________________________________________________________________");
        System.out.println("S.NO - Product Name - Price/Unit - Unit - Total");
        for (Order order : orders) {
            if (SuperMarket.getInstance().checkByName(order)) {
                totalPurchase += processOrder(order);
            }
        }
        System.out.println("__________________________________________________________________");
        System.out.println(">>>> Total Purchase Amount : Rs." + totalPurchase);
    }

    private static float processOrder(Order order) {
        SuperMarket.getInstance().updateStock(order);
        float price = SuperMarket.getInstance().getPrice(order.productName);
        float totalPrice = price * order.getQty();
        System.out.println(order.getProductName() + " ; Rs." + price + " ; " + order.getQty() + " ; Rs." + totalPrice);
        return totalPrice;
    }

}
