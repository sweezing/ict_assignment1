package org.example;
public class Book extends Product {
    private String author;
    private String isbn;
    private String genre;
    
    public Book(String id, String name, double price, int stockQuantity, String author, String isbn, String genre) {
        super(id, name, price, stockQuantity);
        this.author = author;
        this.isbn = isbn;
        this.genre = genre;
    }
    
    public String getAuthor() {
        return author;
    }
    
    public String getIsbn() {
        return isbn;
    }
    
    public String getGenre() {
        return genre;
    }
    
    public void setAuthor(String author) {
        this.author = author;
    }
    
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    
    public void setGenre(String genre) {
        this.genre = genre;
    }
    
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Author: " + author);
        System.out.println("ISBN: " + isbn);
        System.out.println("Genre: " + genre);
    }
    
    @Override
    public String toString() {
        return "Book{" +
                "id='" + getId() + '\'' +
                ", name='" + getName() + '\'' +
                ", price=" + String.format("%.2f", getPrice()) +
                ", stockQuantity=" + getStockQuantity() +
                ", author='" + author + '\'' +
                ", isbn='" + isbn + '\'' +
                ", genre='" + genre + '\'' +
                '}';
    }
}
