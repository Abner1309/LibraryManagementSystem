package com.library.api.repository;

import com.library.api.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AuthorRepository extends JpaRepository<Author, Long> {
    public List<Author> findByName(String name);
    public List<Author> findByNationality(String nationality);
}
