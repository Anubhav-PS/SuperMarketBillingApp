package com.anubhavps.supermarket;

import com.anubhavps.billing.Order;
import com.anubhavps.person.Manager;
import com.anubhavps.products.Products;

import java.util.HashMap;

public class SuperMarket {
    private static SuperMarket superMarket = null;
    String shopName;
    String address;
    String landLine;
    String site;
    Manager manager;
    HashMap<String, Products> storeHouse = new HashMap<>();

    SuperMarket() {
    }

    public SuperMarket(String shopName, String address, String landLine, String site, Manager manager) {
        this.shopName = shopName;
        this.address = address;
        this.landLine = landLine;
        this.site = site;
        this.manager = manager;
    }

    public static SuperMarket getInstance() {
        if (superMarket == null) superMarket = new SuperMarket();
        return superMarket;
    }

    public boolean addProduct(Products product) {
        if (!checkProduct(product)) {
            System.out.println("#### Warning : " + product.getProductName() + " is already present in store house");
            return false;
        }
        storeHouse.put(product.getProductName().toLowerCase(), product);
        return true;
    }

    private boolean checkProduct(Products product) {
        String productName = product.getProductName();
        for (String p1 : storeHouse.keySet()) {
            if (p1.equalsIgnoreCase(productName)) {
                return false;
            }
        }
        return true;
    }


    public boolean checkByName(Order order) {
        for (Products product : storeHouse.values()) {
            if (product.getProductName().equalsIgnoreCase(order.getProductName())) {
                if (product.getProductStock() >= order.getQty()) {
                    return true;
                } else {
                    System.out.println("#### Shortage ,T here are only " + product.getProductStock() + " units of " + order.getProductName() + "available");
                    System.out.println("Sorry we couldn't process that product in your bill");
                    return false;
                }
            }
        }
        System.out.println("#### ERROR ," + order.getProductName() + " is not available in our shop");
        return false;
    }

    public boolean updateStock(Order order) {
        for (Products products : storeHouse.values()) {
            if (products.getProductName().equalsIgnoreCase(order.getProductName())) {
                products.setProductStock(products.getProductStock() - order.getQty());
                return true;
            }
        }
        return false;
    }

    public float getPrice(String productName) {
        for (Products products : storeHouse.values()) {
            if (products.getProductName().equalsIgnoreCase(productName)) {
                return products.getProductPrice();
            }
        }
        System.out.println("#### ERROR ," + productName + " is not available in our shop");
        return 0;
    }

    public int getStock(String productName) {
        for (Products products : storeHouse.values()) {
            if (products.getProductName().equalsIgnoreCase(productName)) {
                return products.getProductStock();
            }
        }
        System.out.println("#### ERROR ," + productName + " is not available in our shop");
        return 0;
    }

    public void displayStock() {
        System.out.println("__________________________________________________________________");
        System.out.println("********Displaying the products present in store house********");
        System.out.println("__________________________________________________________________");
        System.out.println("ProductID ; Product Name ; Price(Rs) ; Qty");
        for (Products product : storeHouse.values()) {
            System.out.println(product.getProductId() + " ; " + product.getProductName() + " ; Rs." + product.getProductPrice() + " ; " + product.getProductStock());
        }
        System.out.println("__________________________________________________________________");
    }

    public boolean getProductDetails(String productName) {
        for (Products products : storeHouse.values()) {
            if (products.getProductName().equalsIgnoreCase(productName)) {
                System.out.println("Product ID : " + products.getProductId());
                System.out.println("Product Name : " + products.getProductName());
                System.out.println("Product Price : " + products.getProductPrice());
                System.out.println("Product Qty : " + products.getProductStock());
                return true;
            }
        }
        System.out.println("#### ERROR ," + productName + " is not available in the store house");
        return false;
    }

    public boolean removeProduct(String productName) {
        for (Products products : storeHouse.values()) {
            if (products.getProductName().equalsIgnoreCase(productName)) {
                storeHouse.remove(products.getProductName());
                System.out.println(productName + " has been removed from store room");
                return true;
            }
        }
        System.out.println("#### ERROR ," + productName + " is not available in the store room");
        return false;
    }

    public boolean increaseStockBy(String productName, int qty) {
        for (Products products : storeHouse.values()) {
            if (products.getProductName().equalsIgnoreCase(productName)) {
                products.setProductStock(products.getProductStock() + qty);
                System.out.println(qty + " more units of " + productName + " has been added in store room");
                return true;
            }
        }
        System.out.println("#### ERROR ," + productName + " is not available in the store house");
        return false;
    }
}
