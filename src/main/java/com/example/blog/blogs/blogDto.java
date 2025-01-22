package com.example.blog.blogs;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

@Valid
public record blogDto(
        @NotNull
                @Email
        String authorEmail,
        String title,
        String content
) {
}
