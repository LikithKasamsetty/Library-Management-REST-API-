package com.lpu.LibraryManagmentAPI.Resopsitory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.lpu.LibraryManagmentAPI.Entity.BookEntity;

@Repository
public interface BookRepository extends JpaRepository<BookEntity, Long> {
}