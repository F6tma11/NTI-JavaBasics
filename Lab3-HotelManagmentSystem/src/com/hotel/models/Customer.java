package com.hotel.models;

public class Customer {

    private String name;
    private String email;
    private String phoneNumber;

    public Customer(String name, String email, String phoneNumber) {
        if (name==null || name.isBlank()){
            System.out.println("Error: You should enter name.");
            throw new IllegalArgumentException("Name can not be null");
        }
        if (email==null||email.isBlank()){
            System.out.println("Error: Email should not be null ");
            throw new IllegalArgumentException("Email can not be null");
        }
        if (!email.contains("@")){
            System.out.println("Error: email should contain @");
            throw new IllegalArgumentException("Email should contain @");
        }
        if (phoneNumber==null || phoneNumber.isBlank()){
            System.out.println("Error:Phone number can not be null.");
            throw new IllegalArgumentException("Phone number can not be null");
        }
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public String toString() {
        return name +
                "  (" + email  +
                ", " + phoneNumber  + ')';
    }
}
