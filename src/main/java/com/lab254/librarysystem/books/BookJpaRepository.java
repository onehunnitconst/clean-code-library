package com.lab254.librarysystem.books;

import com.lab254.librarysystem.books.domain.Book;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookJpaRepository extends JpaRepository<Book, Long> {

}
