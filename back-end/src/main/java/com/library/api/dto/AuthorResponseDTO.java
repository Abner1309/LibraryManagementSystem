package com.library.api.dto;

import com.library.api.model.Author;
import com.library.api.model.Book;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

import java.util.List;

public record AuthorResponseDTO(
        @NotBlank String name,
        @NotBlank String nationality,
        @NotEmpty List<String> books
) {
    public AuthorResponseDTO(Author author) {
        this(
            author.getName(),
            author.getNationality(),
            author.getBooks()
                    .stream()
                    .map(Book::getTitle)
                    .toList()
        );
    }
}
