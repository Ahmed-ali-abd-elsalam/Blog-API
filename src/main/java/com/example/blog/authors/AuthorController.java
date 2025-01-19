package com.example.blog.authors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AuthorController {


    private final AuthorService authorService;

    @Autowired
    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @PostMapping(path = "/Author")
    public Author postAuthor(@RequestBody Author author){
        return authorService.saveAuthor(author);
    }
    @PostMapping(path = "/Authors")
    public List<Author> postAuthors(@RequestBody List<Author> authors){
        return authorService.saveAuthors(authors);
    }

    @GetMapping(path = "/Authors")
    public List<Author> getAuthors(){
        return authorService.getAuthors();
    }

    @GetMapping(path = "/Authors/{AuthorID}")
    public Author getAuthor(@PathVariable Integer AuthorID){
        return authorService.getAuthor(AuthorID);
    }

    @DeleteMapping(path = "/Authors/{AuthorID}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public String deleteAuthor(@PathVariable Integer AuthorID){
        return authorService.removeAuthor(AuthorID);
    }

}
