package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class ECommerceSystem {
    private List<User> users;
    private List<Product> products;
    private List<Order> orders;
    private Scanner scanner;
    private int orderCounter;
    
    public ECommerceSystem() {
        this.users = new ArrayList<>();
        this.products = new ArrayList<>();
        this.orders = new ArrayList<>();
        this.scanner = new Scanner(System.in);
        this.orderCounter = 1;
    }
    
    public void addUser() {
        System.out.println("\nAdd New User\n");
        System.out.println("1. Add Customer");
        System.out.println("2. Add Employee");
        System.out.print("Choose user type (1-2): ");
        
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter email: ");
        String email = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        
        if (choice == 1) {
            System.out.print("Enter address: ");
            String address = scanner.nextLine();
            System.out.print("Enter phone number: ");
            String phone = scanner.nextLine();
            
            Customer customer = new Customer(name, email, password, address, phone);
            users.add(customer);
            System.out.println("Customer added successfully");
        } else if (choice == 2) {
            System.out.print("Enter employee ID: ");
            String empId = scanner.nextLine();
            System.out.print("Enter department: ");
            String department = scanner.nextLine();
            System.out.print("Enter salary: ");
            double salary = scanner.nextDouble();
            scanner.nextLine(); // Consume newline
            
            Employee employee = new Employee(name, email, password, empId, department, salary);
            users.add(employee);
            System.out.println("Employee added successfully");
        }
    }
    
    public void addProduct() {
        System.out.println("\nAdd New Product\n");
        System.out.println("1. Add Book");
        System.out.println("2. Add Electronics");
        System.out.println("3. Add Clothing");
        System.out.print("Choose product type (1-3): ");
        
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        
        System.out.print("Enter product ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter product name: ");
        String name = scanner.nextLine();
        System.out.print("Enter price: ");
        double price = scanner.nextDouble();
        System.out.print("Enter stock quantity: ");
        int stock = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        
        if (choice == 1) {
            System.out.print("Enter author: ");
            String author = scanner.nextLine();
            System.out.print("Enter ISBN: ");
            String isbn = scanner.nextLine();
            System.out.print("Enter genre: ");
            String genre = scanner.nextLine();
            
            Book book = new Book(id, name, price, stock, author, isbn, genre);
            products.add(book);
            System.out.println("Book added successfully");
        } else if (choice == 2) {
            System.out.print("Enter brand: ");
            String brand = scanner.nextLine();
            System.out.print("Enter model: ");
            String model = scanner.nextLine();
            System.out.print("Enter warranty: ");
            String warranty = scanner.nextLine();
            
            Electronics electronics = new Electronics(id, name, price, stock, brand, model, warranty);
            products.add(electronics);
            System.out.println("Electronics added successfully");
        } else if (choice == 3) {
            System.out.print("Enter size: ");
            String size = scanner.nextLine();
            System.out.print("Enter color: ");
            String color = scanner.nextLine();
            System.out.print("Enter material: ");
            String material = scanner.nextLine();
            
            Clothing clothing = new Clothing(id, name, price, stock, size, color, material);
            products.add(clothing);
            System.out.println("Clothing added successfully");
        }
    }
    
    public void listUsers() {
        System.out.println("\nAll Users\n");
        if (users.isEmpty()) {
            System.out.println("No users found");
            return;
        }
        
        for (int i = 0; i < users.size(); i++) {
            User user = users.get(i);
            System.out.print((i + 1) + ". ");
            if (user instanceof Employee) {
                Employee emp = (Employee) user;
                System.out.println("Name: " + emp.getName());
                System.out.println("Email: " + emp.getEmail());
                System.out.println("Role: " + emp.getRole());
                System.out.println("Employee ID: " + emp.getEmployeeId());
                System.out.println("Department: " + emp.getDepartment());
                System.out.println("Salary: $" + String.format("%.2f", emp.getSalary()));
            } else {
                user.displayInfo();
            }
            System.out.println();
        }
    }
    
    public void listProducts() {
        System.out.println("\nAll Products\n");
        if (products.isEmpty()) {
            System.out.println("No products found");
            return;
        }
        
        for (int i = 0; i < products.size(); i++) {
            System.out.println((i + 1) + ". " + products.get(i));
        }
    }
    
    public Customer findCustomerByEmail(String email) {
        for (User user : users) {
            if (user instanceof Customer && user.getEmail().equals(email)) {
                return (Customer) user;
            }
        }
        return null;
    }
    
    public void placeOrder() {
        System.out.println("\nPlace Order\n");
        System.out.print("Enter customer email: ");
        String email = scanner.nextLine();
        
        Customer customer = findCustomerByEmail(email);
        if (customer == null) {
            System.out.println("Customer not found");
            return;
        }
        
        Order order = new Order("ORD" + String.format("%03d", orderCounter++), customer, java.time.LocalDate.now().toString());
        
        System.out.println("Available products:");
        listProducts();
        
        boolean continueShopping = true;
        while (continueShopping) {
            System.out.print("Enter product number to add (0 to finish): ");
            int productIndex = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            
            if (productIndex == 0) {
                continueShopping = false;
            } else if (productIndex > 0 && productIndex <= products.size()) {
                Product product = products.get(productIndex - 1);
                if (product.isInStock()) {
                    order.addProduct(product);
                    product.reduceStock(1);
                    System.out.println(product.getName() + " added to order");
                } else {
                    System.out.println("Product is out of stock");
                }
            } else {
                System.out.println("Invalid product number");
            }
        }
        
        if (!order.getProducts().isEmpty()) {
            orders.add(order);
            customer.addOrder(order);
            System.out.println("Order placed successfully");
            order.printReceipt();
        } else {
            System.out.println("Order cancelled - no products selected");
        }
    }
    
    public void viewAllOrders() {
        System.out.println("\nAll Orders\n");
        if (orders.isEmpty()) {
            System.out.println("No orders found");
            return;
        }
        
        for (int i = 0; i < orders.size(); i++) {
            System.out.println((i + 1) + ". " + orders.get(i));
        }
    }
    
    public void viewCustomerOrders() {
        System.out.println("\nCustomer Orders\n");
        System.out.print("Enter customer email: ");
        String email = scanner.nextLine();
        
        Customer customer = findCustomerByEmail(email);
        if (customer == null) {
            System.out.println("Customer not found");
            return;
        }
        
        customer.viewOrderHistory();
    }
    
    public void displayMainMenu() {
        System.out.println("\nE-Commerce System");
        System.out.println("");
        System.out.println("1. Add User");
        System.out.println("2. Add Product");
        System.out.println("3. List Users");
        System.out.println("4. List Products");
        System.out.println("5. Place Order");
        System.out.println("6. View All Orders");
        System.out.println("7. View Customer Orders");
        System.out.println("8. Exit");
        System.out.print("Choose an option (1-8): ");
    }
    
    public void run() {
        System.out.println("Welcome to the E-Commerce System!");
        
        // Always try interactive mode first
        System.out.println("Starting interactive mode...");
        
        boolean running = true;
        while (running) {
            try {
                displayMainMenu();
                
                // Check if scanner has input
                if (!scanner.hasNextInt()) {
                    System.out.println("No input available. Please run the program in a terminal.");
                    System.out.println("Switching to demo mode...");
                    runDemo();
                    break;
                }
                
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline
            
            switch (choice) {
                case 1:
                    addUser();
                    break;
                case 2:
                    addProduct();
                    break;
                case 3:
                    listUsers();
                    break;
                case 4:
                    listProducts();
                    break;
                case 5:
                    placeOrder();
                    break;
                case 6:
                    viewAllOrders();
                    break;
                case 7:
                    viewCustomerOrders();
                    break;
                case 8:
                    System.out.println("Thank you for using the E-Commerce System");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again");
            }
            } catch (Exception e) {
                System.out.println("Error reading input: " + e.getMessage());
                System.out.println("This might be due to running in an environment without input support.");
                System.out.println("Switching to demo mode...");
                runDemo();
                break;
            }
        }
        
        if (scanner != null) {
            scanner.close();
        }
    }
    
    public void runDemo() {
        System.out.println("\nDEMO MODE\n");
        System.out.println("Showing system functionality...\n");
        
        // Display users
        System.out.println("1. Users:");
        listUsers();
        
        // Display products
        System.out.println("\n2. Products:");
        listProducts();
        
        // Create a sample order only if data exists
        if (!users.isEmpty() && users.get(0) instanceof Customer && products.size() >= 1) {
            System.out.println("\n3. Creating a sample order...");
            Customer customer = (Customer) users.get(0); // First customer
            Order sampleOrder = new Order("ORD" + String.format("%03d", orderCounter++), customer, java.time.LocalDate.now().toString());
            sampleOrder.addProduct(products.get(0));
            products.get(0).reduceStock(1);
            orders.add(sampleOrder);
            customer.addOrder(sampleOrder);
            System.out.println("Sample order created");
            sampleOrder.printReceipt();
        } else {
            System.out.println("\n3. Skipping sample order creation (no users/products)");
        }
        
        // Display all orders
        System.out.println("\n4. All Orders:");
        viewAllOrders();
        
        System.out.println("\n=== DEMO COMPLETE ===");
        System.out.println("To run in interactive mode, use: java -cp build/libs/assignment1-1.0-SNAPSHOT.jar org.example.Main");
    }
}
