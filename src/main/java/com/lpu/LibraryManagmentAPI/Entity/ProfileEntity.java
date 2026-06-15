package com.lpu.LibraryManagmentAPI.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "profiles")
public class ProfileEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;
    private String phone;
    private String address;

    @OneToOne(mappedBy = "profile")
    private UserEntity user;

    public ProfileEntity() {}

    public ProfileEntity(Long id, String email, String phone, String address) {
        this.id = id;
        this.email = email;
        this.phone = phone;
        this.address = address;
    }

    public Long getId() { return id; }
    public String getEmail() { return email; }
    public String getPhone() { return phone; }
    public String getAddress() { return address; }
    public UserEntity getUser() { return user; }

    public void setId(Long id) { this.id = id; }
    public void setEmail(String email) { this.email = email; }
    public void setPhone(String phone) { this.phone = phone; }
    public void setAddress(String address) { this.address = address; }
    public void setUser(UserEntity user) { this.user = user; }
}