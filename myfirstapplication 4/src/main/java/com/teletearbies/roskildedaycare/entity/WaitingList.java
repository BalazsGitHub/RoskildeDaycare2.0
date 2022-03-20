package com.teletearbies.roskildedaycare.entity;

import javax.persistence.*;

@Entity
@Table(name = "waiting_list")
public class WaitingList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, unique = false, length = 45, name = "first_name")
    private String firstName;

    @Column(nullable = false, unique = false, length = 45, name = "last_name")
    private String lastName;

    @Column(nullable = false, unique = false, length = 45, name = "parent_first_name")
    private String parentFirstName;

    @Column(nullable = false, unique = false, length = 45, name = "parent_last_name")
    private String parentLastName;

    @Column(length = 45, nullable = false, name = "address")
    private String address;
    @Column(length = 45, nullable = false, name = "phone_number")
    private String phoneNumber;

    public WaitingList(){

    }

    public WaitingList(String firstName, String lastName, String parentFirstName, String parentLastName, String address, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.parentFirstName = parentFirstName;
        this.parentLastName = parentLastName;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getParentFirstName() {
        return parentFirstName;
    }

    public void setParentFirstName(String parentFirstName) {
        this.parentFirstName = parentFirstName;
    }

    public String getParentLastName() {
        return parentLastName;
    }

    public void setParentLastName(String parentLastName) {
        this.parentLastName = parentLastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
