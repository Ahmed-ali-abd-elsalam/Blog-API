package com.example.blog.authors;

import java.time.LocalDate;

public record AuthorResponseDto(
        String name,
        String email,
        LocalDate dob,
        int noOfBlogs
) {
}
