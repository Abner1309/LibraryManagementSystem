package com.library.api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

import java.util.List;

public record AuthorResponseDTO(
        @NotBlank String name,
        @NotBlank String nationality,
        @NotEmpty List<String> books
) {}
