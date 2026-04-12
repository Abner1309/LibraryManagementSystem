package com.library.api.controller;

import com.library.api.dto.BookCreateDTO;
import com.library.api.dto.BookResponseDTO;
import com.library.api.dto.BookUpdateDTO;
import com.library.api.model.Book;
import com.library.api.service.BookService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/model/Book")
@AllArgsConstructor
public class BookController {
    private final BookService bookService;

    @PostMapping
    public ResponseEntity<BookResponseDTO> addBook(@RequestBody BookCreateDTO book) {
        BookResponseDTO newBook = bookService.saveBook(book);
        return ResponseEntity.status(HttpStatus.CREATED).body(newBook);
    }

    @GetMapping
    public ResponseEntity<List<BookResponseDTO>> getAllBooks() {
        List<BookResponseDTO> books = bookService.listAll();
        return ResponseEntity.ok().body(books);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookResponseDTO> getBookById(@PathVariable Long id) {
        BookResponseDTO book = bookService.findById(id);
        return ResponseEntity.ok().body(book);
    }

    @GetMapping("/{title}")
    public ResponseEntity<List<BookResponseDTO>> getBooksByTitle(@PathVariable String title) {
        List<BookResponseDTO> books = bookService.findByTitle(title);
        return ResponseEntity.ok().body(books);
    }

    @GetMapping("/{isbn}")
    public ResponseEntity<BookResponseDTO> getBooksByIsbn(@PathVariable String isbn) {
        BookResponseDTO book = bookService.findByIsbn(isbn);
        return ResponseEntity.ok().body(book);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BookResponseDTO> updateBook(@RequestBody BookUpdateDTO book) {
        BookResponseDTO newBook = bookService.updateBook(book);
        return ResponseEntity.ok().body(newBook);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
        return ResponseEntity.noContent().build();
    }
}
