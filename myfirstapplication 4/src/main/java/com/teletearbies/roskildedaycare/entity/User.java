package com.teletearbies.roskildedaycare.entity;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {
    @Id
    //ID COLUMN WILL BE GENERATED AUTOMATICALLY
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    //nullable = false - means ITS REQUIRED
    @Column(nullable = false, unique = false, length = 45)
    private String username;

    @Column(nullable = false, length = 15)
    private String password;

    @OneToOne(mappedBy = "userId")
    private Employee employee;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User () {}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
