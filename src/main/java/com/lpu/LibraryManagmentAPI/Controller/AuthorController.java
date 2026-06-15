package com.lpu.LibraryManagmentAPI.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.lpu.LibraryManagmentAPI.Entity.AuthorEntity;
import com.lpu.LibraryManagmentAPI.Service.AuthorService;

import java.util.List;

@RestController
@RequestMapping("/authors")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    // POST /authors → Add new author
    @PostMapping
    public AuthorEntity addAuthor(@RequestBody AuthorEntity author) {
        return authorService.addAuthor(author);
    }

    // GET /authors → Get all authors
    @GetMapping
    public List<AuthorEntity> getAllAuthors() {
        return authorService.getAllAuthors();
    }

    // GET /authors/{id} → Get author by ID
    @GetMapping("/{id}")
    public AuthorEntity getAuthorById(@PathVariable Long id) {
        return authorService.getAuthorById(id);
    }

    // ✅ PUT /authors/{id} → Update author details
    @PutMapping("/{id}")
    public AuthorEntity updateAuthor(@PathVariable Long id, @RequestBody AuthorEntity author) {
        return authorService.updateAuthor(id, author);
    }

    // DELETE /authors/{id} → Delete author
    @DeleteMapping("/{id}")
    public String deleteAuthor(@PathVariable Long id) {
        authorService.deleteAuthor(id);
        return "Author deleted successfully with id: " + id;
    }
}