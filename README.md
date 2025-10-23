# E-Commerce System

A console-based e-commerce system implemented in Java using object-oriented programming principles including inheritance, encapsulation, and collections.

## Features

### User Management
- **User Class**: Base class with common attributes (name, email, password, role)
- **Customer Class**: Extends User with address, phone number, and order history
- **Employee Class**: Extends User with employee ID, department, and salary

### Product Management
- **Product Class**: Base class with ID, name, price, and stock quantity
- **Book Class**: Extends Product with author, ISBN, and genre
- **Electronics Class**: Extends Product with brand, model, and warranty
- **Clothing Class**: Extends Product with size, color, and material

### Order Management
- **Order Class**: Manages customer orders with products, total amount, and receipt generation
- Order tracking and history
- Stock management when orders are placed

## Object-Oriented Design Principles

### Inheritance
- `User` → `Customer` and `Employee`
- `Product` → `Book`, `Electronics`, and `Clothing`

### Encapsulation
- All attributes are private
- Public getters and setters for controlled access
- Methods for business logic (displayInfo, calculateTotal, etc.)

### Collections
- `ArrayList<User>` for user management
- `ArrayList<Product>` for product catalog
- `ArrayList<Order>` for order tracking

## System Operations

1. **Add Users**: Create new customers or employees
2. **Add Products**: Add books, electronics, or clothing items
3. **List Users**: Display all registered users
4. **List Products**: Display all available products
5. **Place Orders**: Customers can place orders with multiple products
6. **View Orders**: Display all orders or customer-specific orders

## Sample Data

The system comes pre-loaded with sample data:
- 2 Customers (John Doe, Jane Smith)
- 1 Employee (Admin User)
- 6 Products (2 Books, 2 Electronics, 2 Clothing items)

## How to Run

1. Build the project:
   ```bash
   ./gradlew build
   ```

2. Run the application:

   **Interactive Mode (Recommended):**
   ```bash
   # Run directly with Java (best for interactive input)
   java -cp build/libs/assignment1-1.0-SNAPSHOT.jar org.example.Main
   
   # Or use the provided script
   ./run_interactive.sh
   ```

   **Gradle Run (may fall back to demo mode):**
   ```bash
   ./gradlew run
   ```

3. **Demo Mode**: If interactive input is not available, the system automatically runs in demo mode showing all functionality with sample data.

## Menu System

The console interface provides an intuitive menu system:
- Main menu with 8 options
- Sub-menus for adding users and products
- Interactive order placement process
- Comprehensive order viewing options

## Class Diagram

```
User
├── Customer (address, phoneNumber, orderHistory)
└── Employee (employeeId, department, salary)

Product
├── Book (author, isbn, genre)
├── Electronics (brand, model, warranty)
└── Clothing (size, color, material)

Order (orderId, customer, products, totalAmount, orderDate, status)
```

## Key Methods

- `displayInfo()`: Shows detailed information for users and products
- `printReceipt()`: Generates formatted order receipts
- `isInStock()`: Checks product availability
- `reduceStock()`: Updates inventory when orders are placed
- `calculateTotal()`: Computes order totals

## Technical Implementation

- **Scanner**: For console input handling
- **ArrayList**: For dynamic collections
- **String formatting**: For currency and display formatting
- **Date handling**: For order timestamps
- **Exception handling**: For input validation

This system demonstrates comprehensive object-oriented programming concepts while providing a functional e-commerce solution.
