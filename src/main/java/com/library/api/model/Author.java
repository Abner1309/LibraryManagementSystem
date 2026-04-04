package com.library.api.model;

import com.library.api.dto.AuthorCreateDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Author {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String nationality;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "author")
    private List<Book> books;

    public Author(AuthorCreateDTO dto) {
        this.name = dto.name();
        this.nationality = dto.nationality();
    }
}
