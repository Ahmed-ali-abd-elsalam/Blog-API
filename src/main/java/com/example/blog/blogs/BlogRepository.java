package com.example.blog.blogs;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BlogRepository extends JpaRepository<Blog,Integer> {
     List<Blog> findBytitleIgnoreCaseLike(String blogname);
}
