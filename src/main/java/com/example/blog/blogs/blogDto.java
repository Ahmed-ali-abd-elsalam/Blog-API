package com.example.blog.blogs;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

@Valid
public record blogDto(
        @NotNull
        String author,
        String title,
        String content
) {
}
