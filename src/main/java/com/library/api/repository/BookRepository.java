package com.library.api.repository;

import com.library.api.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Long> {
    public List<Book> findByName(String name);
    public List<Book> findByAuthor(String author);
    public List<Book> findByTitle(String title);
    public Optional<Book> findByIsbn(String isbn);
}
