package com.lab254.librarysystem.books;

import com.lab254.librarysystem.books.domain.Book;
import com.lab254.librarysystem.books.domain.Rent;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RentJpaRepository extends JpaRepository<Rent, Long> {
    List<Rent> findByUserId(Long userId);
}
