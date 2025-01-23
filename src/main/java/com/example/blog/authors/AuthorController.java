package com.example.blog.authors;

import jakarta.validation.Valid;
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


    @PostMapping(path = "/Authors")
    @ResponseStatus(HttpStatus.CREATED)
    public List<AuthorDto> postAuthors(@RequestBody List<AuthorDto> authorsDto){
        return authorService.saveAuthors(authorsDto);
    }

    @GetMapping(path = "/Authors")
    public List<AuthorResponseDto> getAuthors(){
        return authorService.getAuthors();
    }

    @GetMapping(path = "/Authors/{AuthorID}")
    public AuthorResponseDto getAuthor(@PathVariable Integer AuthorID){
        return authorService.getAuthor(AuthorID);
    }
    @DeleteMapping(path = "/Authors/{AuthorID}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public String deleteAuthor(@PathVariable Integer AuthorID){
        return authorService.removeAuthor(AuthorID);
    }

    @PostMapping(path = "/Author")
    @ResponseStatus(HttpStatus.CREATED)
    public AuthorDto postAuthor(@Valid @RequestBody AuthorDto authorDto){
        return authorService.saveAuthor(authorDto);
    }

    @GetMapping(path = "/Author")
    public List<AuthorResponseDto> getAuthorByName(@RequestParam("AuthorName") String author){
        return authorService.getAuthorByName(author);
    }




}
