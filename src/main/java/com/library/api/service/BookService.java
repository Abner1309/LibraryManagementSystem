package com.library.api.service;

import com.library.api.dto.BookCreateDTO;
import com.library.api.dto.BookResponseDTO;
import com.library.api.dto.BookUpdateDTO;
import com.library.api.exception.BookAlreadyRegisteredException;
import com.library.api.exception.BookNotExistException;
import com.library.api.model.Book;
import com.library.api.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service @RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;

    @Transactional
    public BookResponseDTO saveBook(BookCreateDTO dto) {
        Book verify = bookRepository.findByIsbn(dto.isbn());
        if (verify != null) {
            throw new BookAlreadyRegisteredException();
        }
        Book book = new Book(dto);
        book = bookRepository.save(book);
        return new BookResponseDTO(book);
    }

    public List<BookResponseDTO> listAll() {
        List<Book> books = bookRepository.findAll();
        return books.stream().map(BookResponseDTO::new).collect(Collectors.toList());
    }

    public BookResponseDTO findById(Long id) {
        Book book = bookRepository.findById(id)
                .orElseThrow(BookNotExistException::new);
        return new BookResponseDTO(book);
    }

    public List<BookResponseDTO> findByTitle(String title) {
        List<Book> books = bookRepository.findByTitle(title);
        return books.stream().map(BookResponseDTO::new).collect(Collectors.toList());
    }

    public BookResponseDTO findByIsbn(String isbn) {
        Book book = bookRepository.findByIsbn(isbn);
        if (book == null) { throw new BookNotExistException(); }
        return new BookResponseDTO(book);
    }

    @Transactional
    public BookResponseDTO updateBook(BookUpdateDTO dto) {
        Book book = bookRepository.findById(dto.id()).orElseThrow(BookNotExistException::new);
        book.updateBook(dto);
        book = bookRepository.save(book);
        return new BookResponseDTO(book);
    }

    @Transactional
    public void deleteBook(Long id) {
        Book book = bookRepository.findById(id).orElseThrow(BookNotExistException::new);
        bookRepository.delete(book);
    }
}
