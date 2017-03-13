package helloworld.advprog.mmu.ac.uk.advancedprogramming2;

import java.io.Serializable;

public class Person implements Serializable {
    private String gender;
    private String name;
    private String natInscNo;
    private String dob;
    private String address;
    private String postcode; // attributes of a person declared as variables
    public Person(String gender, String name, String natInscNo, String dob, String address, String postcode) {
        this.gender = gender;
        this.name = name;
        this.natInscNo = natInscNo;
        this.dob = dob;
        this.address = address;
        this.postcode = postcode;
    }
    public String getGender() { // getters and setters for each variable
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getNatInscNo() {
        return natInscNo;
    }
    public void setNatInscNo(String natInscNo) {
        this.natInscNo = natInscNo;
    }
    public String getDob() {
        return dob;
    }
    public void setDob(String dob) {
        this.dob = dob;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getPostcode() {
        return postcode;
    }
    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

}
