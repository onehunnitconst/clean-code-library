package com.lab254.librarysystem.books.dto;

import com.lab254.librarysystem.books.domain.Book;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class BookDto {
    private Long id;
    private String isbn;
    private String title;
    private String author;
    private String publisher;
    private boolean isRent;

    public BookDto(Book book) {
        this.id = book.getId();
        this.isbn = book.getIsbn();
        this.title = book.getTitle();
        this.author = book.getAuthor();
        this.publisher = book.getPublisher();
        if (book.getRentList().isEmpty()) {
            this.isRent = false;
        } else {
            this.isRent = book.getRentList().stream().anyMatch((rent) -> LocalDateTime.now().isBefore(rent.getExpireDate().toLocalDateTime()));
        }
    }
}
