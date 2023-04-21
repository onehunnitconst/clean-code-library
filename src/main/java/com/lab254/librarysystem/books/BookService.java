package com.lab254.librarysystem.books;

import com.lab254.librarysystem.books.domain.Book;
import com.lab254.librarysystem.books.domain.Rent;
import com.lab254.librarysystem.books.dto.BookDto;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class BookService {
    private BookJpaRepository bookRepository;
    private RentJpaRepository rentRepository;

    public Book createBook(Book book) {
        return bookRepository.save(book);
    }

    public List<BookDto> findBooks(Pageable pageable) {
        List<Book> books = bookRepository.findAll(pageable).toList();
        return books.stream().map((book) -> new BookDto(book)).toList();
    }

    public BookDto findBookById(Long id) {
        Book book = bookRepository.findById(id).orElseThrow(() -> new IllegalStateException());
        return new BookDto(book);
    }

    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }

    public void rentBook(Long userId, Long bookId) {
        Rent rent = new Rent();
        LocalDateTime rentDate = LocalDateTime.now();
        LocalDateTime expireDate = LocalDateTime.now();
        expireDate = expireDate.plusDays(7);

        rent.setUserId(userId);
        rent.setBookId(bookId);
        rent.setRentDate(Timestamp.valueOf(rentDate));
        rent.setExpireDate(Timestamp.valueOf(expireDate));

        List<Rent> currentRentList = rentRepository.findByUserId(userId);

        if (currentRentList.size() >= 2) {
            throw new IllegalStateException();
        }

        rentRepository.save(rent);
    }
}
