package com.lpu.LibraryManagmentAPI.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lpu.LibraryManagmentAPI.Entity.AuthorEntity;
import com.lpu.LibraryManagmentAPI.Resopsitory.AuthorRepository;

import java.util.List;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    // CREATE - Add new author
    public AuthorEntity addAuthor(AuthorEntity author) {
        return authorRepository.save(author);
    }

    // READ - Get all authors
    public List<AuthorEntity> getAllAuthors() {
        return authorRepository.findAll();
    }

    // READ - Get author by ID
    public AuthorEntity getAuthorById(Long id) {
        return authorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Author not found with id: " + id));
    }

    // UPDATE - Update author details
    public AuthorEntity updateAuthor(Long id, AuthorEntity updatedAuthor) {
        AuthorEntity existing = authorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Author not found with id: " + id));

        existing.setName(updatedAuthor.getName());
        existing.setBio(updatedAuthor.getBio());

        return authorRepository.save(existing);
    }

    //  DELETE - Delete author by ID
    public void deleteAuthor(Long id) {
        if (!authorRepository.existsById(id)) {
            throw new RuntimeException("Author not found with id: " + id);
        }
        authorRepository.deleteById(id);
    }
}