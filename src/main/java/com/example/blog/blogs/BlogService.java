package com.example.blog.blogs;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Service
public class BlogService {
    private final BlogRepository blogRepository;
    @Autowired
    public BlogService(BlogRepository blogRepository) {
        this.blogRepository = blogRepository;
    }

    private Blog blogDtoMapper(blogDto dto){
        return Blog.builder().author(dto.author()).title(dto.title()).content(dto.content()).build();
    }
    private blogDto blogMapper(Blog blog){
        return new blogDto(blog.getAuthor(),blog.getTitle(),blog.getContent());
    }

    public blogDto SaveBlog(@Valid blogDto blogdto) {
        var blog = blogDtoMapper(blogdto);
        blog.setCreatedAt(LocalDateTime.now());
        blogRepository.save(blog);
        return blogdto;
    }

    public List<blogDto> SaveBlogs(@Valid List<blogDto> blogdtos) {
        blogRepository.saveAll(
                blogdtos.stream().map((blogdto)->{
                    var blog =  blogDtoMapper(blogdto);
                    blog.setCreatedAt(LocalDateTime.now());
                    return blog;
                }).toList()
                );
        return blogdtos;
    }

    public List<blogDto> getBlogs() {
        return blogRepository.findAll().stream().map((blog )-> blogMapper(blog)).toList();
    }

    public blogDto getBlog(Integer BlogID){
        return blogRepository.findById(BlogID).map(blog -> blogMapper(blog)).orElse(new blogDto("N/A","",""));
    }

    public String deleteBlog(Integer blogID) {
        blogRepository.deleteById(blogID);
        return "Blog" +blogID +"Deleted";
    }


}
