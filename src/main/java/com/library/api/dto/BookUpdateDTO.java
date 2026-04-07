package com.library.api.dto;

import com.library.api.model.Author;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record BookUpdateDTO(
        @NotNull Long id,
        @NotNull Author author,
        @NotBlank String title,
        @NotBlank String isbn
) {}
