package com.example.week8.service;

import com.example.week8.dto.AuthorDto;
import com.example.week8.model.Author;
import com.example.week8.repository.AuthorRepository;
import com.example.week8.util.AuthorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class AuthorService {
    private AuthorRepository authorRepository;
    private AuthorMapper authorMapper;

    @Autowired
    public AuthorService(AuthorRepository authorRepository, AuthorMapper authorMapper) {
        this.authorRepository = authorRepository;
        this.authorMapper = authorMapper;
    }

    public void addNewAuthor(AuthorDto authorDto){
        authorRepository.save(authorMapper.reverse(authorDto));
    }

    public Collection<AuthorDto> getAllAuthors(){
        return authorRepository.findAll()
                .stream()
                .map(authorMapper::map)
                .collect(Collectors.toList());
    }
}
