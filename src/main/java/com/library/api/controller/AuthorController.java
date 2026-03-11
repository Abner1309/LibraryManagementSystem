package com.library.api.controller;

import com.library.api.model.Author;
import com.library.api.service.AuthorService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/model/Author")
@AllArgsConstructor
public class AuthorController {
    private AuthorService authorService;

    @PostMapping
    public ResponseEntity<String> addAuthor(@RequestBody Author author) {
        if (!authorService.saveAuthor(author)) { return ResponseEntity.badRequest().body("Please check the fields again."); }
        return ResponseEntity.ok().body("Author added successfully.");
    }

    @GetMapping
    public ResponseEntity<List<Author>> getAllAuthors() {
        List<Author> authors = authorService.findAll();
        return ResponseEntity.ok().body(authors);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Author> getAuthorById(@PathVariable Long id) {
        Author author = authorService.findById(id);
        if (author == null) { return ResponseEntity.notFound().build(); }
        return ResponseEntity.ok().body(author);
    }

    @GetMapping("/{name}")
    public ResponseEntity<List<Author>> getAuthorByName(@PathVariable String name) {
        List<Author> author = authorService.findByName(name);
        if (author == null) { return ResponseEntity.notFound().build(); }
        return ResponseEntity.ok().body(author);
    }

    @GetMapping("/{nationality}")
    public ResponseEntity<List<Author>> getAuthorByNationality(@PathVariable String nationality) {
        List<Author> author = authorService.findByNationality(nationality);
        if (author == null) { return ResponseEntity.notFound().build(); }
        return ResponseEntity.ok().body(author);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateAuthor(@PathVariable Long id, @RequestBody Author author) {
        if (!authorService.updateAuthor(id, author)) { return ResponseEntity.badRequest().body("The author could not be updated."); }
        return ResponseEntity.ok().body("Book updated successfully.");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAuthor(@PathVariable Long id) {
        if (!authorService.deleteAuthor(id)) { return ResponseEntity.badRequest().body("The author could not be deleted."); }
        return ResponseEntity.ok().body("Book deleted successfully.");
    }
}
