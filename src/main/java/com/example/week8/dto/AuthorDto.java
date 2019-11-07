package com.example.week8.dto;

import com.example.week8.model.Note;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AuthorDto {

    private long userId;

    private String firstName;

    private String lastName;

    private List<Note> noteList;

    public AuthorDto() {
    }

    public AuthorDto(long userId, String firstName, String lastName, List<Note> noteList) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.noteList = noteList;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<Note> getNoteList() {
        return noteList;
    }

    public void setNoteList(List<Note> noteList) {
        this.noteList = noteList;
    }
}
