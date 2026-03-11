package com.library.api.service;

import com.library.api.model.Book;
import com.library.api.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service @RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;

    @Transactional
    public boolean saveBook(Book book) {
        if (book.getTitle().isEmpty() || book.getIsbn().isEmpty()) { return false; }
        Book searchBook = bookRepository.findByIsbn(book.getIsbn());
        if (searchBook != null) { return false; }
        bookRepository.save(book);
        return true;
    }

    public List<Book> listAll() {
        return bookRepository.findAll();
    }

    public Book findById(Long id) {
        return bookRepository.findById(id).orElse(null);
    }

    public List<Book> findByTitle(String title) {
        List<Book> books = bookRepository.findByTitle(title);
        if (books.isEmpty()) { books = null; }
        return books;
    }

    public Book findByIsbn(String isbn) {
        return bookRepository.findByIsbn(isbn);
    }

    @Transactional
    public boolean updateBook(Long id, Book updatedBook) {
        Book book = bookRepository.findById(id).orElse(null);
        if (book == null) { return false; }
        book.setTitle(updatedBook.getTitle());
        book.setAuthor(updatedBook.getAuthor());
        book.setIsbn(updatedBook.getIsbn());
        bookRepository.save(book);
        return true;
    }

    @Transactional
    public boolean deleteBook(Long id) {
        Book book = bookRepository.findById(id).orElse(null);
        if (book == null) { return false; }
        bookRepository.delete(book);
        return true;
    }
}
