package com.anubhavps;

import com.anubhavps.billing.ProcessBill;
import com.anubhavps.person.Customer;
import com.anubhavps.person.Gender;
import com.anubhavps.person.Manager;
import com.anubhavps.stock.Stock;
import com.anubhavps.supermarket.SuperMarket;

import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("******* Welcome to setup Wizard *******");

        System.out.println("$ Please enter Manger name : ");
        String managerName = scanner.next();
        System.out.println("$ " + managerName + " ,Enter your gender : ");
        String gender = scanner.next();
        gender = gender.toUpperCase();
        Gender gender1;
        switch (gender) {
            case "MALE":
                gender1 = Gender.MALE;
                break;
            case "FEMALE":
                gender1 = Gender.FEMALE;
                break;
            case "OTHER":
            default:
                gender1 = Gender.OTHER;
        }
        System.out.println("$ Enter your work number without prefixing +91 : ");
        String phoneNum = getPhoneNum();
        System.out.println("$ Enter your work mailId : ");
        String mailId = scanner.next();
        Manager manager = new Manager(managerName, gender1, phoneNum, mailId);
        System.out.println("-----------------------------------------------------------------");
        System.out.println("Manager  details are : ");
        System.out.println(manager.toString());
        System.out.println("-----------------------------------------------------------------");
        System.out.println("Mr." + managerName + ", Please enter the shop details asked below : ");
        System.out.println("$ Enter the shop name : ");
        String shopName = scanner.next();
        System.out.println("$ Enter address of " + shopName + " : ");
        String address = scanner.next();
        System.out.println("$ Enter the landline number without prefixing +044 : ");
        String landLine = getLandLine();
        System.out.println("$ Enter website name : ");
        String website = scanner.next();
        SuperMarket superMarket = new SuperMarket(shopName, address, landLine, website, manager);
        System.out.println("********SHOP DETAILS SAVED SUCCESSFULLY********");
        System.out.println("-----------------------------------------------------------------");
        System.out.println("*********Create Store Room********");
        Stock.displayHeader();
        while (Stock.storeProduct()) {

        }
        Stock.checkAdd();
        Stock.displayAvailableStock();
        System.out.println("************* You are all set now *************");
        displayOptions();
        String input = scanner.next();
        processOption(input);
    }

    private static String getPhoneNum() {
        String phoneNum = scanner.next();
        if (phoneNum.length() != 10) {
            System.out.println("#### ERROR , Incorrect number ,Please Enter again : ");
            phoneNum = getPhoneNum();
        }
        return phoneNum;
    }

    private static String getLandLine() {
        String phoneNum = scanner.next();
        if (phoneNum.length() != 8) {
            System.out.println("#### ERROR , Incorrect number ,Please Enter again : ");
            phoneNum = getLandLine();
        }
        return phoneNum;
    }

    private static void processOption(String input) {
        input = input.toLowerCase();
        switch (input) {
            case "1":
                takeOrders();
                break;
            case "2":
                knowThePrice();
                break;
            case "3":
                knowTheStock();
                break;
            case "4":
                increaseTheStock();
                break;
            case "5":
                addNewProduct();
                break;
            case "6":
                removeProduct();
                break;
            case "7":
                displayProductDetails();
                break;
            case "8":
                displayAllProductsAvailable();
                break;
            case "0":
                displayOptions();
                break;
            case "exit":
                System.exit(0);
                break;
            default:
                System.out.println("#### ERROR : Invalid option number selected, please check the option available");
                System.out.println("Please Enter a valid option again");
                input = scanner.next();
                processOption(input);
        }
    }

    private static void displayAllProductsAvailable() {
        Stock.displayAvailableStock();
        displayOptions();
        String input = scanner.next();
        processOption(input);
    }

    private static void removeProduct() {
        System.out.println("$ Enter the product name to be removed : ");
        Stock.removeProduct();
        displayOptions();
        String input = scanner.next();
        processOption(input);
    }

    private static void increaseTheStock() {
        System.out.println("$ Enter the product name to increase the units : ");
        Stock.increaseStock();
        displayOptions();
        String input = scanner.next();
        processOption(input);

    }

    private static void addNewProduct() {
        Stock.displayHeader();
        while (Stock.storeProduct()) {

        }
        Stock.checkAdd();
        Stock.displayAvailableStock();
        displayOptions();
    }

    private static void displayProductDetails() {
        System.out.println("$ Enter the product name to know its detail : ");
        Stock.displayProductDetail();
        displayOptions();
        String input = scanner.next();
        processOption(input);
    }

    private static void knowTheStock() {
        System.out.println("$ Enter the product name to know its units available : ");
        String productName = scanner.next();
        productName = productName.toLowerCase();
        Stock.getStock(productName);
        displayOptions();
        String input = scanner.next();
        processOption(input);
    }

    private static void knowThePrice() {
        System.out.println("$ Enter the product name to know its price : ");
        String productName = scanner.next();
        productName = productName.toLowerCase();
        Stock.getPrice(productName);
        displayOptions();
        String input = scanner.next();
        processOption(input);
    }

    private static void takeOrders() {

        System.out.println("$ Enter customer name : ");
        String name = scanner.next();
        System.out.println("$ Enter gender : ");
        String gender = scanner.next();
        gender = gender.toUpperCase();
        Gender gender1;
        switch (gender) {
            case "MALE":
                gender1 = Gender.MALE;
                break;
            case "FEMALE":
                gender1 = Gender.FEMALE;
                break;
            case "OTHER":
            default:
                gender1 = Gender.OTHER;
        }
        System.out.println("$ Enter phone number : ");
        String phoneNumber = getPhoneNum();
        System.out.println("$ Enter email id : ");
        String mailId = scanner.next();
        Customer customer = new Customer(name, gender1, phoneNumber, mailId);
        System.out.println("-----------------------------------------------------------------");
        System.out.println("$ Enter product name and number of units separated by ';' : ");
        ProcessBill.displayHeader();
        while (ProcessBill.takeInOrders(customer)) {

        }
        ProcessBill.checkAndProcess();

        displayOptions();
        String input = scanner.next();
        processOption(input);
    }

    private static void displayOptions() {
        System.out.println("-----------------------------------------------------------------");
        System.out.println("Enter 1 to take orders");
        System.out.println("Enter 2 to know  the price of product");
        System.out.println("Enter 3 to know the stock left");
        System.out.println("Enter 4 to increase stock of a product");
        System.out.println("Enter 5 to add new products to the store room");
        System.out.println("Enter 6 to remove a product from the store room");
        System.out.println("Enter 7 to display the product details of product present in store room");
        System.out.println("Enter 8 to display all the product available in the store room");
        System.out.println("Enter 0 to display the options again");
        System.out.println("Enter 'exit' to quit");
        String input = scanner.next();
        System.out.println("-----------------------------------------------------------------");
        processOption(input);
    }


}
