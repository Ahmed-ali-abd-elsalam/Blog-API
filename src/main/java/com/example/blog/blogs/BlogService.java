package com.example.blog.blogs;

import com.example.blog.authors.Author;
import com.example.blog.authors.AuthorRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class BlogService {
    private final BlogRepository blogRepository;
    private final AuthorRepository authorRepository;

    @Autowired
    public BlogService(BlogRepository blogRepository,AuthorRepository authorRepository) {
        this.blogRepository = blogRepository;
        this.authorRepository = authorRepository;
    }

    private Blog blogDtoMapper(blogDto dto) {
        Author author = authorRepository.findByemail(dto.authorEmail()).orElseThrow();
        return Blog.builder().authorEmail(dto.authorEmail()).title(dto.title()).author(author).content(dto.content()).build();
    }
    private blogDto blogMapper(Blog blog){
        return new blogDto(blog.getAuthorEmail(),blog.getTitle(),blog.getContent());
    }

    public blogDto SaveBlog(@Valid blogDto blogdto) {
        var blog = blogDtoMapper(blogdto);
        Author author = blog.getAuthor();
        author.setNoOfBlogs(author.getNoOfBlogs()+1);
        blog.setCreatedAt(LocalDateTime.now());
        blogRepository.save(blog);
        return blogdto;
    }

    public List<blogDto> SaveBlogs(@Valid List<blogDto> blogdtos) {
        blogRepository.saveAll(
                blogdtos.stream().map((blogdto)->{
                    var blog =  blogDtoMapper(blogdto);
                    Author author = blog.getAuthor();
                    author.setNoOfBlogs(author.getNoOfBlogs()+1);
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
        Blog blog = blogRepository.findById(blogID).orElseThrow(() -> new RuntimeException("No such Blog"));
        Author author = blog.getAuthor();
        author.setNoOfBlogs(author.getNoOfBlogs()-1);
        blogRepository.deleteById(blogID);
        return "Blog" +blogID +"Deleted";
    }


    public List<blogDto> getBlogByTitle(String blogname) {
        return blogRepository.findBytitleIgnoreCaseLike(blogname).stream().map(blog -> blogMapper(blog)).toList();
    }
}
