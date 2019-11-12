package com.example.week8.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "notes")
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long noteId;

    @Column
    private String noteTitle;

    @Column
    private String noteContent;

    @Column
    private LocalDateTime noteCreationDate = LocalDateTime.now();

    @Column
    private LocalDateTime noteEditionDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id")
    private Author author;

    public Note() {
    }

    public Note(String noteTitle, String noteContent, LocalDateTime noteCreationDate,
                LocalDateTime noteEditionDate, Author author) {
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

    /*@Override
    public String toString() {
        return "Note{" +
                "noteId=" + noteId +
                ", noteTitle='" + noteTitle + '\'' +
                ", noteContent='" + noteContent + '\'' +
                ", noteCreationDate=" + noteCreationDate +
                ", noteEditionDate=" + noteEditionDate +
                ", userApp=" + author +
                '}';
    }*/
}
