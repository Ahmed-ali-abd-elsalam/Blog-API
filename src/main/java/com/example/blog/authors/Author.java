package com.example.blog.authors;

import com.example.blog.blogs.Blog;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Transactional
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

    @OneToMany(mappedBy = "author",fetch = FetchType.EAGER)
    @JsonManagedReference
    @ToString.Exclude
    private List<Blog> blogs;


}
