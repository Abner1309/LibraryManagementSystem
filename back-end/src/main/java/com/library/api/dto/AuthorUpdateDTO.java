package com.library.api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record AuthorUpdateDTO (
        @NotNull Long id,
        @NotBlank String name,
        @NotBlank String nationality
) {}
