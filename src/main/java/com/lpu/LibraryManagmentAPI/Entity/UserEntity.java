package com.lpu.LibraryManagmentAPI.Entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String username;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "profile_id", referencedColumnName = "id")
    private ProfileEntity profile;

    @OneToMany(mappedBy = "borrowedBy")
    private List<BookEntity> borrowedBooks;

    public UserEntity() {}

    public UserEntity(Long id, String name, String username, ProfileEntity profile) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.profile = profile;
    }

    public Long getId() { return id; }
    public String getName() { return name; }
    public String getUsername() { return username; }
    public ProfileEntity getProfile() { return profile; }
    public List<BookEntity> getBorrowedBooks() { return borrowedBooks; }

    public void setId(Long id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setUsername(String username) { this.username = username; }
    public void setProfile(ProfileEntity profile) { this.profile = profile; }
    public void setBorrowedBooks(List<BookEntity> borrowedBooks) { this.borrowedBooks = borrowedBooks; }
}