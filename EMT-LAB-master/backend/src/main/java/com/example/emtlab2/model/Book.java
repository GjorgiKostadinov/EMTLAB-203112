package com.example.emtlab2.model;


import com.example.emtlab2.model.enumerations.Category;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToOne
    private Author author;

    private Integer availableCopies;
    @Enumerated(value = EnumType.STRING)
    private Category category;

    public Book(String name,Category category, Author author, Integer availableCopies) {
        this.name = name;
        this.author = author;
        this.availableCopies = availableCopies;
        this.category = category;
    }

    public Book() {

    }
}