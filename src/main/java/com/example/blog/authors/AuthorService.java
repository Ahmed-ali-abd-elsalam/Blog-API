package com.example.blog.authors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {

    private final AuthorRepository authorRepository;

    @Autowired
    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }



    public Author saveAuthor(Author author) {
        return authorRepository.save(author);
    }

    public List<Author> saveAuthors(List<Author> authors) {
        return authorRepository.saveAll(authors);
    }

    public List<Author> getAuthors() {
        return authorRepository.findAll();
    }

    public Author getAuthor(Integer AuthorID){
        return authorRepository.findById(AuthorID).orElse(new Author());
    }

    public String removeAuthor(Integer authorID) {
        authorRepository.deleteById(authorID);
        return "Author " + authorID +" IsDeleted";
    }

}
