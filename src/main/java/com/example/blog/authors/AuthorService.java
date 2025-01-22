package com.example.blog.authors;

import com.example.blog.blogs.Blog;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AuthorService {

    private final AuthorRepository authorRepository;

    @Autowired
    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public Author dtoMapper(AuthorDto authorDto){
        return Author.builder().name(authorDto.name()).email(authorDto.email()).dob(authorDto.dob()).build();
    }

    public AuthorResponseDto authorMapper(Author author){
        ArrayList<String> Titles = new ArrayList<>();
        for(Blog blog:author.getBlogs()){
            Titles.add(blog.getTitle());
        }
        return new AuthorResponseDto(author.getName(),author.getEmail(),author.getDob(),author.getNoOfBlogs(),Titles);
    }


    public AuthorDto saveAuthor(@Valid AuthorDto authorDto) {
        authorRepository.save(dtoMapper(authorDto));
        return authorDto;
    }

    public List<AuthorDto> saveAuthors(List<AuthorDto> authorsDto) {
        authorRepository.saveAll(authorsDto.stream()
                        .map(authorDto -> dtoMapper(authorDto))
                        .toList());
        return authorsDto;
    }

    public List<AuthorResponseDto> getAuthors() {
        return authorRepository.findAll().stream().map(author -> authorMapper(author)).toList();
    }

    public AuthorResponseDto getAuthor(Integer AuthorID){
        Optional<Author> optional = authorRepository.findById(AuthorID);
        if (optional.isPresent()) {
            Author author = optional.get();
            return authorMapper(optional.get());
        }else {
            return  new AuthorResponseDto("N/A","N/A",LocalDate.MIN,-1,new ArrayList<String>());
        }
    }

    public String removeAuthor(Integer authorID) {
        authorRepository.deleteById(authorID);
        return "Author " + authorID +" IsDeleted";
    }

    public List<AuthorResponseDto> getAuthorByName(String author) {
        return authorRepository.findByname(author).stream().map(author1 -> authorMapper(author1)).toList();
    }
}
