package com.example.blog.blogs;

import com.example.blog.authors.Author;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;
import lombok.extern.jackson.Jacksonized;

import java.time.LocalDateTime;
@Jacksonized
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(uniqueConstraints =
@UniqueConstraint(columnNames = {"title","authorEmail"}))
public class Blog {
    @Id
    @SequenceGenerator(name = "IDGenerator",allocationSize = 1)
    @GeneratedValue(generator ="IDGenerator",strategy = GenerationType.SEQUENCE)
    private Integer ID;
    @Column(nullable = false)
    private String authorEmail;
    private String title;
    private String content;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;


    @ManyToOne(fetch =FetchType.EAGER)
    @JoinColumn(name = "authorID")
    @JsonBackReference
    @ToString.Exclude
    private Author author;

}
