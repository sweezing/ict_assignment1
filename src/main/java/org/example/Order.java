package org.example;

import java.util.ArrayList;
import java.util.List;
public class Order {
    private String orderId;
    private Customer customer;
    private List<Product> products;
    private double totalAmount;
    private String orderDate;
    private String status;
    
    public Order(String orderId, Customer customer, String orderDate) {
        this.orderId = orderId;
        this.customer = customer;
        this.orderDate = orderDate;
        this.products = new ArrayList<>();
        this.totalAmount = 0.0;
        this.status = "Pending";
    }
    
    public String getOrderId() {
        return orderId;
    }
    
    public Customer getCustomer() {
        return customer;
    }
    
    public List<Product> getProducts() {
        return products;
    }
    
    public double getTotalAmount() {
        return totalAmount;
    }
    
    public String getOrderDate() {
        return orderDate;
    }
    
    public String getStatus() {
        return status;
    }
    
    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }
    
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    
    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }
    
    public void addProduct(Product product) {
        products.add(product);
        totalAmount += product.getPrice();
    }
    
    public boolean removeProduct(Product product) {
        if (products.remove(product)) {
            totalAmount -= product.getPrice();
            return true;
        }
        return false;
    }
    
    public void calculateTotal() {
        totalAmount = 0.0;
        for (Product product : products) {
            totalAmount += product.getPrice();
        }
    }
    
    public void printReceipt() {
        System.out.println("Order Receipt\n");
        System.out.println("Order ID: " + orderId);
        System.out.println("Customer: " + customer.getName());
        System.out.println("Email: " + customer.getEmail());
        System.out.println("Order Date: " + orderDate);
        System.out.println("Status: " + status);
        System.out.println("");
        System.out.println("Products:");
        
        for (int i = 0; i < products.size(); i++) {
            Product product = products.get(i);
            System.out.println((i + 1) + ". " + product.getName() + " - $" + String.format("%.2f", product.getPrice()));
        }
        
        System.out.println("");
        System.out.println("Total Amount: $" + String.format("%.2f", totalAmount));
    }
    
    public void displayOrderSummary() {
        System.out.println("Order ID: " + orderId);
        System.out.println("Customer: " + customer.getName());
        System.out.println("Date: " + orderDate);
        System.out.println("Products: " + products.size());
        System.out.println("Total: $" + String.format("%.2f", totalAmount));
        System.out.println("Status: " + status);
    }
    
    @Override
    public String toString() {
        return "Order{" +
                "orderId='" + orderId + '\'' +
                ", customer=" + customer.getName() +
                ", products=" + products.size() +
                ", totalAmount=" + String.format("%.2f", totalAmount) +
                ", orderDate='" + orderDate + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
