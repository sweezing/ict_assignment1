package org.example;

import java.util.ArrayList;
import java.util.List;
public class Customer extends User {
    private String address;
    private String phoneNumber;
    private List<Order> orderHistory;
    
    public Customer(String name, String email, String password, String address, String phoneNumber) {
        super(name, email, password, "Customer");
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.orderHistory = new ArrayList<>();
    }
    
    public String getAddress() {
        return address;
    }
    
    public String getPhoneNumber() {
        return phoneNumber;
    }
    
    public List<Order> getOrderHistory() {
        return orderHistory;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }
    
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    
    public void addOrder(Order order) {
        orderHistory.add(order);
    }
    
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Address: " + address);
        System.out.println("Phone: " + phoneNumber);
        System.out.println("Total Orders: " + orderHistory.size());
    }
    
    public void viewOrderHistory() {
        if (orderHistory.isEmpty()) {
            System.out.println("No orders found");
            return;
        }
        
        System.out.println("Order History for " + getName() + ":");
        for (int i = 0; i < orderHistory.size(); i++) {
            System.out.println((i + 1) + ". " + orderHistory.get(i));
        }
    }
}
