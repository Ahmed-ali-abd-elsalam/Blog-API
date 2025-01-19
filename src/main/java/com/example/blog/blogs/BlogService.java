package com.example.blog.blogs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class BlogService {
    private final BlogRepository blogRepository;
    @Autowired
    public BlogService(BlogRepository blogRepository) {
        this.blogRepository = blogRepository;
    }

    public Blog SaveBlog(Blog blog) {
        blog.setCreatedAt(LocalDateTime.now());
        return blogRepository.save(blog);
    }

    public List<Blog> getBlogs() {
        return blogRepository.findAll();
    }

    public String deleteBlog(Integer blogID) {
        blogRepository.deleteById(blogID);
        return "Blog" +blogID +"Deleted";
    }

    public Blog getBlog(Integer BlogID){
        return blogRepository.findById(BlogID).orElse(new Blog());
    }
}
