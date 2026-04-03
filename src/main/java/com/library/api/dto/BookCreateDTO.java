package com.library.api.dto;

import com.library.api.model.Author;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record BookCreateDTO(
        @NotNull Author author,
        @NotBlank String title,
        @NotBlank String isbn
) {}
