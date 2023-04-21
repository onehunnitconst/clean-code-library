package com.lab254.librarysystem.books.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Table(name = "books")
@NoArgsConstructor
@Entity
@Getter @Setter
public class Book {
    @Id
    @GeneratedValue
    @Column
    private Long id;

    private String isbn;

    private String title;

    private String author;

    private String publisher;

    @OneToMany(mappedBy = "book", cascade = CascadeType.PERSIST)
    private List<Rent> rentList = new ArrayList<>();
}
