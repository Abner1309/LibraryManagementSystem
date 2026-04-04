package com.library.api.dto;

import jakarta.validation.constraints.NotBlank;

import java.util.List;

public record AuthorCreateDTO(
        @NotBlank String name,
        @NotBlank String nationality
) {}
