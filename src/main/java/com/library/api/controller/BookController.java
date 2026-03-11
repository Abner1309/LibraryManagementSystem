package com.library.api.controller;

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
    public ResponseEntity<String> addBook(@RequestBody Book book) {
        if (!bookService.saveBook(book)) { return ResponseEntity.badRequest().body("Please check the fields again."); }
        return ResponseEntity.status(HttpStatus.CREATED).body("Book added successfully.");
    }

    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks() {
        List<Book> books = bookService.listAll();
        return ResponseEntity.ok().body(books);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Long id) {
        Book book = bookService.findById(id);
        if (book == null) { return ResponseEntity.notFound().build(); }
        return ResponseEntity.ok().body(book);
    }

    @GetMapping("/{title}")
    public ResponseEntity<List<Book>> getBooksByTitle(@PathVariable String title) {
        List<Book> books = bookService.findByTitle(title);
        if (books == null) { return ResponseEntity.notFound().build(); }
        return ResponseEntity.ok().body(books);
    }

    @GetMapping("/{isbn}")
    public ResponseEntity<Book> getBooksByIsbn(@PathVariable String isbn) {
        Book book = bookService.findByIsbn(isbn);
        if (book == null) { return ResponseEntity.notFound().build(); }
        return ResponseEntity.ok().body(book);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateBook(@PathVariable Long id, @RequestBody Book book) {
        if (!bookService.updateBook(id, book)) { return ResponseEntity.badRequest().body("The book could not be updated."); }
        return ResponseEntity.ok().body("Book updated successfully.");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable Long id) {
        if (!bookService.deleteBook(id)) { return ResponseEntity.badRequest().body("The book could not be deleted."); }
        return ResponseEntity.ok().body("Book deleted successfully.");
    }
}
