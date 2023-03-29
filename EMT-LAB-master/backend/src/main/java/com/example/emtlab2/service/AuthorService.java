package com.example.emtlab2.service;


import com.example.emtlab2.model.Author;

import java.util.Optional;

public interface AuthorService {

    void create(String name, String surname, Long countryId);

    Optional<Author> findByNameAndSurname(String name, String surname);

    Optional<Author> findById(Long id);
}
