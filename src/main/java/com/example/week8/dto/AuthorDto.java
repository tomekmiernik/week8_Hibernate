package com.example.week8.dto;

import com.example.week8.model.Note;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotEmpty;
import java.util.List;

@Component
public class AuthorDto {

    private long authorId;

    @NotEmpty(message = "Ta wartość jest wymagana")
    private String firstName;

    @NotEmpty(message = "Ta wartość jest wymagana")
    private String lastName;

    private List<Note> noteList;

    public AuthorDto() {
    }

    public AuthorDto(long authorId, String firstName, String lastName, List<Note> noteList) {
        this.authorId = authorId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.noteList = noteList;
    }

    public long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(long authorId) {
        this.authorId = authorId;
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
