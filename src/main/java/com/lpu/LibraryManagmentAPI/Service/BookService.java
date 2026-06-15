package com.lpu.LibraryManagmentAPI.Service;

import com.lpu.LibraryManagmentAPI.Entity.BookEntity;
import com.lpu.LibraryManagmentAPI.Entity.UserEntity;
import com.lpu.LibraryManagmentAPI.Exception.BookAlreadyBorrowedException;
import com.lpu.LibraryManagmentAPI.Exception.BookNotFoundException;
import com.lpu.LibraryManagmentAPI.Resopsitory.BookRepository;
import com.lpu.LibraryManagmentAPI.Resopsitory.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private UserRepository userRepository;

    // CREATE - Add new book
    public BookEntity addBook(BookEntity book) {
        return bookRepository.save(book);
    }

    // READ - Get all books
    public List<BookEntity> getAllBooks() {
        return bookRepository.findAll();
    }

    // READ - Get book by ID
    public BookEntity getBookById(Long id) {
        return bookRepository.findById(id)
                .orElseThrow(() -> new BookNotFoundException("Book not found with id: " + id));
    }

    // UPDATE - Update book details
    public BookEntity updateBook(Long id, BookEntity updatedBook) {
        BookEntity existing = bookRepository.findById(id)
                .orElseThrow(() -> new BookNotFoundException("Book not found with id: " + id));

        existing.setTitle(updatedBook.getTitle());
        existing.setIsbn(updatedBook.getIsbn());
        existing.setAuthor(updatedBook.getAuthor());
        existing.setCategories(updatedBook.getCategories());

        return bookRepository.save(existing);
    }

    // DELETE - Delete book (clears book_categories first to avoid FK violation)
    public void deleteBook(Long id) {
        BookEntity book = bookRepository.findById(id)
                .orElseThrow(() -> new BookNotFoundException("Book not found with id: " + id));

        book.setCategories(new ArrayList<>());
        bookRepository.save(book);
        bookRepository.delete(book);
    }

    // BORROW - Borrow a book
    public BookEntity borrowBook(Long bookId, Long userId) {
        BookEntity book = bookRepository.findById(bookId)
                .orElseThrow(() -> new BookNotFoundException("Book not found with id: " + bookId));

        if (book.isBorrowed()) {
            throw new BookAlreadyBorrowedException("Book is already borrowed by someone!");
        }

        UserEntity user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + userId));

        book.setBorrowed(true);
        book.setBorrowedBy(user);
        return bookRepository.save(book);
    }

    // RETURN - Return a borrowed book
    public BookEntity returnBook(Long bookId, Long userId) {
        BookEntity book = bookRepository.findById(bookId)
                .orElseThrow(() -> new BookNotFoundException("Book not found with id: " + bookId));

        if (!book.isBorrowed()) {
            throw new RuntimeException("Book is not currently borrowed!");
        }

        if (!book.getBorrowedBy().getId().equals(userId)) {
            throw new RuntimeException("This book was not borrowed by this user!");
        }

        book.setBorrowed(false);
        book.setBorrowedBy(null);
        return bookRepository.save(book);
    }
}