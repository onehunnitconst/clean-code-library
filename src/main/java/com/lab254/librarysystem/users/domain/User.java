package com.lab254.librarysystem.users.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "users")
@NoArgsConstructor
@Entity
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue
    @Column
    private Long id;

    private String name;

    private String userId;

    @JsonIgnore
    private String password;
}
