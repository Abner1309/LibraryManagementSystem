package com.library.api.model;

import com.library.api.dto.AuthorCreateDTO;
import com.library.api.dto.AuthorUpdateDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
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
    private List<Book> books = new ArrayList<>();

    public Author(AuthorCreateDTO dto) {
        this.name = dto.name();
        this.nationality = dto.nationality();
    }

    public void updateAuthor(AuthorUpdateDTO dto) {
        this.setName(dto.name());
        this.setNationality(dto.nationality());
    }
}
