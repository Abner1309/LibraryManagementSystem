package com.library.api.dto;

import com.library.api.model.Book;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

import java.util.List;

public record AuthorCreateDTO(
        @NotBlank String name,
        @NotBlank String nationality,
        @NotEmpty List<Book> books
) {}
