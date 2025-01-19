package com.example.blog.blogs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BlogController {
    private final BlogService blogService;
    @Autowired
    public BlogController(BlogService blogService) {
        this.blogService = blogService;
    }

    @PostMapping(path = "/blogs")
    public Blog PostBlog(@RequestBody Blog blog){
        System.out.println("Blog from body"+blog);
        return blogService.SaveBlog(blog);
    }

    @GetMapping(path = "/blogs")
    public List<Blog> GetBlogs(){
        return blogService.getBlogs();
    }

    @GetMapping(path = "/blogs/{BlogID}")
    public Blog getBlog(@PathVariable Integer BlogID){
        return blogService.getBlog(BlogID);
    }

    @DeleteMapping(path = "/blogs/{BlogID}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public String deleteBlog(@PathVariable(name = "BlogID") Integer BlogID){
        return blogService.deleteBlog(BlogID);
    }
}
