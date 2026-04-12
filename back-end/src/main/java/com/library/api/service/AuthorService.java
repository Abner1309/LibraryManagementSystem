package com.library.api.service;

import com.library.api.dto.AuthorCreateDTO;
import com.library.api.dto.AuthorResponseDTO;
import com.library.api.dto.AuthorUpdateDTO;
import com.library.api.exception.AuthorAlreadyExistException;
import com.library.api.exception.AuthorNotExistException;
import com.library.api.model.Author;
import com.library.api.repository.AuthorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service @RequiredArgsConstructor
public class AuthorService {
    private final AuthorRepository authorRepository;

    @Transactional
    public AuthorResponseDTO saveAuthor(AuthorCreateDTO dto) {
        if (authorRepository.existsByNameAndNationality(dto.name(), dto.nationality())) {
            throw new AuthorAlreadyExistException();
        }
        Author author = new Author(dto);
        author = authorRepository.save(author);
        return new AuthorResponseDTO(author);
    }

    public List<AuthorResponseDTO> findAll() {
        List<Author> authors = authorRepository.findAll();
        if (authors.isEmpty()) {
            throw new AuthorNotExistException();
        }
        return authors.stream().map(AuthorResponseDTO::new).collect(Collectors.toList());
    }

    public AuthorResponseDTO findById(Long id) {
        Author author = authorRepository.findById(id).orElseThrow(AuthorNotExistException::new);
        return new AuthorResponseDTO(author);
    }

    public List<AuthorResponseDTO> findByName(String name) {
        List<Author> authors = authorRepository.findByName(name);
        if (authors.isEmpty()) {
            throw new AuthorNotExistException();
        }
        return authors.stream().map(AuthorResponseDTO::new).collect(Collectors.toList());
    }

    public List<AuthorResponseDTO> findByNationality(String nationality) {
        List<Author> authors = authorRepository.findByNationality(nationality);
        if (authors.isEmpty()) {
            throw new AuthorNotExistException();
        }
        return authors.stream().map(AuthorResponseDTO::new).collect(Collectors.toList());
    }

    @Transactional
    public AuthorResponseDTO updateAuthor(AuthorUpdateDTO dto) {
        Author author = authorRepository.findById(dto.id()).orElseThrow(AuthorNotExistException::new);
        author.updateAuthor(dto);
        author = authorRepository.save(author);
        return new AuthorResponseDTO(author);
    }

    @Transactional
    public void deleteAuthor(Long id) {
        Author author = authorRepository.findById(id).orElseThrow(AuthorNotExistException::new);
        authorRepository.delete(author);
    }
}
