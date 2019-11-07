package com.example.week8.util;

import com.example.week8.dto.NoteDto;
import com.example.week8.model.Note;
import org.springframework.stereotype.Component;

@Component
public class NoteMapper implements Mapper<Note, NoteDto> {
    @Override
    public NoteDto map(Note from) {
        NoteDto newNoteDto = new NoteDto();
        newNoteDto.setNoteId(from.getNoteId());
        newNoteDto.setNoteTitle(from.getNoteTitle());
        newNoteDto.setNoteContent(from.getNoteContent());
        newNoteDto.setNoteCreationDate(from.getNoteCreationDate());
        newNoteDto.setNoteEditionDate(from.getNoteEditionDate());
        newNoteDto.setAuthor(from.getAuthor());
        return newNoteDto;
    }

    @Override
    public Note reverse(NoteDto to) {
        Note newNote = new Note();
        newNote.setNoteId(to.getNoteId());
        newNote.setNoteTitle(to.getNoteTitle());
        newNote.setNoteContent(to.getNoteContent());
        newNote.setNoteCreationDate(to.getNoteCreationDate());
        newNote.setNoteEditionDate(to.getNoteEditionDate());
        newNote.setAuthor(to.getAuthor());
        return newNote;
    }
}
