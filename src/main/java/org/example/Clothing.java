package org.example;
public class Clothing extends Product {
    private String size;
    private String color;
    private String material;
    
    public Clothing(String id, String name, double price, int stockQuantity, String size, String color, String material) {
        super(id, name, price, stockQuantity);
        this.size = size;
        this.color = color;
        this.material = material;
    }
    
    public String getSize() {
        return size;
    }
    
    public String getColor() {
        return color;
    }
    
    public String getMaterial() {
        return material;
    }
    
    public void setSize(String size) {
        this.size = size;
    }
    
    public void setColor(String color) {
        this.color = color;
    }
    
    public void setMaterial(String material) {
        this.material = material;
    }
    
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Size: " + size);
        System.out.println("Color: " + color);
        System.out.println("Material: " + material);
    }
    
    @Override
    public String toString() {
        return "Clothing{" +
                "id='" + getId() + '\'' +
                ", name='" + getName() + '\'' +
                ", price=" + String.format("%.2f", getPrice()) +
                ", stockQuantity=" + getStockQuantity() +
                ", size='" + size + '\'' +
                ", color='" + color + '\'' +
                ", material='" + material + '\'' +
                '}';
    }
}
