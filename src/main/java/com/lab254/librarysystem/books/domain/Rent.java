package com.lab254.librarysystem.books.domain;

import com.lab254.librarysystem.users.domain.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.Date;

@Table(name = "rent")
@NoArgsConstructor
@Entity
@Getter @Setter
public class Rent {
    @Id
    @GeneratedValue
    @Column
    private Long id;

    @ManyToOne(targetEntity = User.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    private User user;

    @Column(name = "user_id")
    private Long userId;

    @ManyToOne(targetEntity = Book.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "book_id", insertable = false, updatable = false)
    private Book book;

    @Column(name = "book_id")
    private Long bookId;

    @Column
    private Timestamp rentDate;

    @Column
    private Timestamp expireDate;
}
