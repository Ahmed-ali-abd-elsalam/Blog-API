package com.example.blog.blogs;

import jakarta.validation.Valid;
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
    @ResponseStatus(HttpStatus.CREATED)
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


    @PostMapping(path = "/blog")
    @ResponseStatus(HttpStatus.CREATED)
    public blogDto PostBlog(@Valid @RequestBody blogDto blogdto){
        return blogService.SaveBlog(blogdto);
    }

    @GetMapping(path = "/blog")
    public List<blogDto> getBlogByTitle(@RequestParam(name = "Title") String title){
        System.out.println("title "+ title);
        return blogService.getBlogByTitle(title);
    }




}
