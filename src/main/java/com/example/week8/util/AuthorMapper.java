package com.example.week8.util;

import com.example.week8.dto.AuthorDto;
import com.example.week8.model.Author;
import org.springframework.stereotype.Component;

@Component
public class AuthorMapper implements Mapper<Author, AuthorDto> {
    @Override
    public AuthorDto map(Author from) {
        AuthorDto newAuthorDto = new AuthorDto();
        newAuthorDto.setAuthorId(from.getAuthorId());
        newAuthorDto.setFirstName(from.getFirstName());
        newAuthorDto.setLastName(from.getLastName());
        newAuthorDto.setNoteList(from.getNoteList());
        return newAuthorDto;
    }

    @Override
    public Author reverse(AuthorDto to) {
        Author newAuthor = new Author();
        newAuthor.setAuthorId(to.getAuthorId());
        newAuthor.setFirstName(to.getFirstName());
        newAuthor.setLastName(to.getLastName());
        newAuthor.setNoteList(to.getNoteList());
        return newAuthor;
    }
}
