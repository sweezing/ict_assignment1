package org.example;
public class Employee extends User {
    private String employeeId;
    private String department;
    private double salary;
    
    public Employee(String name, String email, String password, String employeeId, String department, double salary) {
        super(name, email, password, "Employee");
        this.employeeId = employeeId;
        this.department = department;
        this.salary = salary;
    }
    
    public String getEmployeeId() {
        return employeeId;
    }
    
    public String getDepartment() {
        return department;
    }
    
    public double getSalary() {
        return salary;
    }
    
    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }
    
    public void setDepartment(String department) {
        this.department = department;
    }
    
    public void setSalary(double salary) {
        this.salary = salary;
    }
    
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Employee ID: " + employeeId);
        System.out.println("Department: " + department);
        System.out.println("Salary: $" + String.format("%.2f", salary));
    }
    
    public double calculateAnnualSalary() {
        return salary * 12;
    }
}
