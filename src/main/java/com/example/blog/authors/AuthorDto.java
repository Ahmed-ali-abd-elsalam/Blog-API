package com.example.blog.authors;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;

import java.time.LocalDate;

public record AuthorDto(
        @NotNull
        String name,
        @Email
        String email,
        @PastOrPresent
        LocalDate dob) {
}
