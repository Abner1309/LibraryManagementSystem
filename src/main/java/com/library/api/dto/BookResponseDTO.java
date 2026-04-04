package com.library.api.dto;

import com.library.api.model.Author;
import com.library.api.model.Book;
import jakarta.validation.constraints.NotBlank;

public record BookResponseDTO(
        @NotBlank String author,
        @NotBlank String title,
        @NotBlank String isbn
) {
    public BookResponseDTO(Book book) {
        this(
            book.getAuthor().getName(),
            book.getTitle(),
            book.getIsbn()
        );
    }
}
