package com.example.restfulwebservices.user;

import java.util.Date;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

public class User {
    
    private Integer id;

    @Size(min = 2, message = "Name should have atleast 2 characters")
    private String name;

    @Past
    private Date birthaDate;
    
    public User(Integer id, String name, Date birthaDate) {
        this.id = id;
        this.name = name;
        this.birthaDate = birthaDate;
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Date getBirthaDate() {
        return birthaDate;
    }
    public void setBirthaDate(Date birthaDate) {
        this.birthaDate = birthaDate;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", name=" + name + ", birthaDate=" + birthaDate + "]";
    }
    
}
