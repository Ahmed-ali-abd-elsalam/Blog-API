package com.example.blog.authors;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Author {

    @Id
    @SequenceGenerator(name = "AuthorID",allocationSize = 2)
    @GeneratedValue(generator = "AuthorID", strategy = GenerationType.SEQUENCE)
    private Integer Id;
    private String name;
    @Column(unique = true)
    private String email;
    private LocalDate dob;
    private int noOfBlogs;

}
