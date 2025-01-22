package com.example.blog.authors;

import java.time.LocalDate;
import java.util.ArrayList;

public record AuthorResponseDto(
        String name,
        String email,
        LocalDate dob,
        int noOfBlogs,
        ArrayList<String>blogNames
) {
}
