package com.example.blog.blogs;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class Blog {
    @Id
    @SequenceGenerator(name = "IDGenerator",allocationSize = 1)
    @GeneratedValue(generator ="IDGenerator",strategy = GenerationType.SEQUENCE)
    private Integer ID;
    @Column(nullable = false)
    private String author;
    private String title;
    private String content;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;

}
