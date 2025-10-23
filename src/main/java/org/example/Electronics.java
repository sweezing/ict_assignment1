package org.example;
public class Electronics extends Product {
    private String brand;
    private String model;
    private String warranty;
    
    public Electronics(String id, String name, double price, int stockQuantity, String brand, String model, String warranty) {
        super(id, name, price, stockQuantity);
        this.brand = brand;
        this.model = model;
        this.warranty = warranty;
    }
    
    public String getBrand() {
        return brand;
    }
    
    public String getModel() {
        return model;
    }
    
    public String getWarranty() {
        return warranty;
    }
    
    public void setBrand(String brand) {
        this.brand = brand;
    }
    
    public void setModel(String model) {
        this.model = model;
    }
    
    public void setWarranty(String warranty) {
        this.warranty = warranty;
    }
    
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Brand: " + brand);
        System.out.println("Model: " + model);
        System.out.println("Warranty: " + warranty);
    }
    
    @Override
    public String toString() {
        return "Electronics{" +
                "id='" + getId() + '\'' +
                ", name='" + getName() + '\'' +
                ", price=" + String.format("%.2f", getPrice()) +
                ", stockQuantity=" + getStockQuantity() +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", warranty='" + warranty + '\'' +
                '}';
    }
}
