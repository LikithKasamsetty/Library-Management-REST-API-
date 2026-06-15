package com.lpu.LibraryManagmentAPI.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "books")
public class BookEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String isbn;

    // ✅ FIX: Use Boolean (wrapper) instead of boolean (primitive)
    //         so NULL values from existing DB rows don't cause a crash
    @Column(name = "is_borrowed")
    private Boolean borrowed = false;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id")
    @JsonBackReference
    private AuthorEntity author;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "book_categories",
        joinColumns = @JoinColumn(name = "book_id"),
        inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    private List<CategoryEntity> categories;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "borrowed_by_user_id")
    private UserEntity borrowedBy;

    public BookEntity() {}

    public BookEntity(Long id, String title, String isbn, AuthorEntity author, List<CategoryEntity> categories) {
        this.id = id;
        this.title = title;
        this.isbn = isbn;
        this.author = author;
        this.categories = categories;
    }

    public BookEntity(Long id, String title, String isbn, AuthorEntity author,
                      List<CategoryEntity> categories, UserEntity borrowedBy) {
        this.id = id;
        this.title = title;
        this.isbn = isbn;
        this.author = author;
        this.categories = categories;
        this.borrowedBy = borrowedBy;
    }

    public Long getId() { return id; }
    public String getTitle() { return title; }
    public String getIsbn() { return isbn; }

    
    public boolean isBorrowed() { return borrowed != null && borrowed; }

    public AuthorEntity getAuthor() { return author; }
    public List<CategoryEntity> getCategories() { return categories; }
    public UserEntity getBorrowedBy() { return borrowedBy; }

    public void setId(Long id) { this.id = id; }
    public void setTitle(String title) { this.title = title; }
    public void setIsbn(String isbn) { this.isbn = isbn; }
    public void setBorrowed(Boolean borrowed) { this.borrowed = borrowed; }
    public void setAuthor(AuthorEntity author) { this.author = author; }
    public void setCategories(List<CategoryEntity> categories) { this.categories = categories; }
    public void setBorrowedBy(UserEntity borrowedBy) { this.borrowedBy = borrowedBy; }
}