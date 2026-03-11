package com.library.api.service;

import com.library.api.model.Author;
import com.library.api.repository.AuthorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service @RequiredArgsConstructor
public class AuthorService {
    private final AuthorRepository authorRepository;

    @Transactional
    public boolean saveAuthor(Author author) {
        if (author.getName().isEmpty() || author.getNationality().isEmpty()) { return false; }
        authorRepository.save(author);
        return true;
    }

    public List<Author> findAll() { return authorRepository.findAll(); }

    public Author findById(Long id) { return authorRepository.findById(id).orElse(null); }

    public List<Author> findByName(String name) { return authorRepository.findByName(name); }

    public List<Author> findByNationality(String nationality) { return authorRepository.findByNationality(nationality); }

    @Transactional
    public boolean updateAuthor(Long id, Author updatedAuthor) {
        Author author = authorRepository.findById(id).orElse(null);
        if (author == null) { return false; }
        author.setName(updatedAuthor.getName());
        author.setNationality(updatedAuthor.getNationality());
        authorRepository.save(author);
        return true;
    }

    @Transactional
    public boolean deleteAuthor(Long id) {
        Author author = authorRepository.findById(id).orElse(null);
        if (author == null) { return false; }
        authorRepository.delete(author);
        return true;
    }
}
