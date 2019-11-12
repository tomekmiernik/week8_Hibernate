package com.example.week8.dto;

import com.example.week8.model.Author;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

public class NoteDto {

    private long noteId;

    @NotEmpty(message = "Ta wartość jest wymagana")
    private String noteTitle;

    @NotEmpty(message = "Ta wartość jest wymagana")
    private String noteContent;

    private LocalDateTime noteCreationDate;

    private LocalDateTime noteEditionDate;

    @NotNull
    private Author author;

    public NoteDto() {
    }

    public NoteDto(long noteId, String noteTitle, String noteContent,
                   LocalDateTime noteCreationDate, LocalDateTime noteEditionDate, Author author) {
        this.noteId = noteId;
        this.noteTitle = noteTitle;
        this.noteContent = noteContent;
        this.noteCreationDate = noteCreationDate;
        this.noteEditionDate = noteEditionDate;
        this.author = author;
    }

    public long getNoteId() {
        return noteId;
    }

    public void setNoteId(long noteId) {
        this.noteId = noteId;
    }

    public String getNoteTitle() {
        return noteTitle;
    }

    public void setNoteTitle(String noteTitle) {
        this.noteTitle = noteTitle;
    }

    public String getNoteContent() {
        return noteContent;
    }

    public void setNoteContent(String noteContent) {
        this.noteContent = noteContent;
    }

    public LocalDateTime getNoteCreationDate() {
        return noteCreationDate;
    }

    public void setNoteCreationDate(LocalDateTime noteCreationDate) {
        this.noteCreationDate = noteCreationDate;
    }

    public LocalDateTime getNoteEditionDate() {
        return noteEditionDate;
    }

    public void setNoteEditionDate(LocalDateTime noteEditionDate) {
        this.noteEditionDate = noteEditionDate;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
}
