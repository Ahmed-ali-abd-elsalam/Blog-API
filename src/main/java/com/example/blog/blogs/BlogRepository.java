package com.example.blog.blogs;

import com.example.blog.authors.Author;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BlogRepository extends JpaRepository<Blog,Integer> {
    public List<Blog> findBytitleIgnoreCaseLike(String blogname);
}
