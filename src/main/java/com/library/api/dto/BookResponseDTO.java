package com.library.api.dto;

import com.library.api.model.Author;
import jakarta.validation.constraints.NotBlank;

public record BookResponseDTO(
        @NotBlank String author,
        @NotBlank String title,
        @NotBlank String isbn
) {}
