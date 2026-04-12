package com.library.api.controller;

import com.library.api.dto.AuthorCreateDTO;
import com.library.api.dto.AuthorResponseDTO;
import com.library.api.dto.AuthorUpdateDTO;
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
    public ResponseEntity<AuthorResponseDTO> addAuthor(@RequestBody AuthorCreateDTO author) {
        AuthorResponseDTO newAuthor = authorService.saveAuthor(author);
        return ResponseEntity.ok().body(newAuthor);
    }

    @GetMapping
    public ResponseEntity<List<AuthorResponseDTO>> getAllAuthors() {
        List<AuthorResponseDTO> authors = authorService.findAll();
        return ResponseEntity.ok().body(authors);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AuthorResponseDTO> getAuthorById(@PathVariable Long id) {
        AuthorResponseDTO author = authorService.findById(id);
        return ResponseEntity.ok().body(author);
    }

    @GetMapping("/{name}")
    public ResponseEntity<List<AuthorResponseDTO>> getAuthorByName(@PathVariable String name) {
        List<AuthorResponseDTO> author = authorService.findByName(name);
        return ResponseEntity.ok().body(author);
    }

    @GetMapping("/{nationality}")
    public ResponseEntity<List<AuthorResponseDTO>> getAuthorByNationality(@PathVariable String nationality) {
        List<AuthorResponseDTO> authors = authorService.findByNationality(nationality);
        return ResponseEntity.ok().body(authors);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AuthorResponseDTO> updateAuthor(@RequestBody AuthorUpdateDTO author) {
        AuthorResponseDTO newAuthor = authorService.updateAuthor(author);
        return ResponseEntity.ok().body(newAuthor);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAuthor(@PathVariable Long id) {
        authorService.deleteAuthor(id);
        return ResponseEntity.noContent().build();
    }
}
