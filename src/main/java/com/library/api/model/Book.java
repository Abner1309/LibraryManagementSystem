package com.library.api.model;

import com.library.api.dto.BookCreateDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String isbn;
    @ManyToOne(fetch = FetchType.LAZY)
    private Author author;

    public Book(BookCreateDTO dto) {
        this.title = dto.title();
        this.isbn = dto.isbn();
        this.author = dto.author();
    }
}
