package com.example.blog.blogs;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
public class BlogController {
    private final BlogService blogService;
    @Autowired
    public BlogController(BlogService blogService) {
        this.blogService = blogService;
    }



    @PostMapping(path = "/blog")
    public blogDto PostBlog(@Valid @RequestBody blogDto blogdto){
        return blogService.SaveBlog(blogdto);
    }
    public List<blogDto> PostBlog(@Valid @RequestBody List<blogDto> blogdto){
        return blogService.SaveBlogs(blogdto);
    }

    @GetMapping(path = "/blogs")
    public List<blogDto> GetBlogs(){
        return blogService.getBlogs();
    }

    @GetMapping(path = "/blogs/{BlogID}")
    public blogDto getBlog(@PathVariable Integer BlogID){
        return blogService.getBlog(BlogID);
    }

    @DeleteMapping(path = "/blogs/{BlogID}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public String deleteBlog(@PathVariable(name = "BlogID") Integer BlogID){
        return blogService.deleteBlog(BlogID);
    }
}
