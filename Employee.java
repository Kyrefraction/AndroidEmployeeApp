package helloworld.advprog.mmu.ac.uk.advancedprogramming2;

import java.io.Serializable;

public class Employee extends Person implements Serializable { // an employee is a person, therefore it extends the person class

    private String id;
    private String salary;
    private String startDate;
    private String title;
    private String email;

    public Employee(String id, String name, String gender, String dob, String address, String postcode, String natInscNo,
                    String title, String startDate, String salary, String email) {
        super(gender, name, natInscNo, dob, address, postcode);
        this.id = id;
        this.salary = salary;
        this.startDate = startDate;
        this.title = title;
        this.email = email;
    }
    // getters and setters for the employee class
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getSalary() {
        return salary;
    }
    public void setSalary(String salary) {
        this.salary = salary;
    }
    public String getStartDate() {
        return startDate;
    }
    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    } // getting the employee information method
    public String toString() {
        return"\nID: " + getId() + " Name: " + super.getName() + " Gender: " + super.getGender() + " DOB: " + super.getDob() + " Address: " + super.getAddress() + " Postcode: " + super.getPostcode() + " National Insurance Number: " + super.getNatInscNo() + " Job Title: " + getTitle() + " Start Date: " + getStartDate() + " Salary: " + getSalary() + " Email: " + getEmail();
    }
}
