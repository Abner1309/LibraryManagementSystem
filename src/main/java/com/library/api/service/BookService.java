package com.library.api.service;

import com.library.api.model.Book;
import com.library.api.repository.BookRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service @RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;

    @Transactional
    public void saveBook(Book book) {
        if (book.getTitle().isEmpty() || book.getAuthor().isEmpty() || book.getIsbn().isEmpty()) {
            throw new RuntimeException("There are empty field.");
        }

        Book searchBook = bookRepository.findByIsbn(book.getIsbn()).orElse(null);
        if (searchBook != null) {
            throw new RuntimeException("Book already exists.");
        }

        bookRepository.save(book);
    }

    public List<Book> listAll() {
        return bookRepository.findAll();
    }

    public Book findById(Long id) {
        return bookRepository.findById(id).orElse(null);
    }

    public List<Book> findByAuthor(String author) {
        List<Book> books = bookRepository.findByAuthor(author);
        if (books.isEmpty()) {
            throw new RuntimeException("There is no such book.");
        }
        return books;
    }

    public List<Book> findByTitle(String title) {
        List<Book> books = bookRepository.findByTitle(title);
        if (books.isEmpty()) {
            throw new RuntimeException("There is no such book.");
        }
        return books;
    }

    public Optional<Book> findByIsbn(String isbn) {
        return bookRepository.findByIsbn(isbn);
    }

    @Transactional
    public void updateBook(Long id, Book updatedBook) {
        Book book = bookRepository.findById(id).orElse(null);
        if (book == null) {
            throw new RuntimeException("Book not found.");
        }
        book.setTitle(updatedBook.getTitle());
        book.setAuthor(updatedBook.getAuthor());
        book.setIsbn(updatedBook.getIsbn());
        bookRepository.save(book);
    }

    @Transactional
    public void deleteBook(Long id) {
        Book book = bookRepository.findById(id).orElse(null);
        if (book == null) {
            throw new RuntimeException("Book not found.");
        }
        bookRepository.delete(book);
    }
}
