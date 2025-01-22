package com.example.blog.authors;

import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AuthorRepository extends JpaRepository<Author,Integer> {
     List<Author> findByname(String name);

     Optional<Author> findByemail(@NotNull String s);
}
