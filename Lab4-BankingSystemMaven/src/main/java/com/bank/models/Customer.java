package com.bank.models;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Customer {
    private String id;
    private String name;
    private String email;
    private static final Logger log= LoggerFactory.getLogger(Customer.class);
    public Customer(String id, String name, String email) {
        if (id==null||id.isBlank()){
            log.error("Error: ID can not be null");
            throw new IllegalArgumentException("ID can not be empty");
        }

        if (name==null || name.isBlank()){
            log.error("Error: name can not be null");
            throw new IllegalArgumentException("Name can not be null");
        }

        if (email==null||email.isBlank()){
            log.error("Error: email can not be null");
            throw new IllegalArgumentException("Email can not be null");
        }

        if (!email.contains("@")){
            log.error("Error: Email should contain @");
            throw new IllegalArgumentException("Email should contain @");
        }
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return name +
                "(" + id +
                ", " + email +
                ')';
    }
}
