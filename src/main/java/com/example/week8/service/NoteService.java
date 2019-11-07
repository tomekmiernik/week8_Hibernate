package com.example.week8.service;

import com.example.week8.dto.NoteDto;
import com.example.week8.repository.NoteRepository;
import com.example.week8.util.NoteMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class NoteService {
    private NoteRepository noteRepository;
    private NoteMapper noteMapper;

    @Autowired
    public NoteService(NoteRepository noteRepository, NoteMapper noteMapper) {
        this.noteRepository = noteRepository;
        this.noteMapper = noteMapper;
    }

    public void addNewNote(NoteDto noteDto) {
        noteRepository.save(noteMapper.reverse(noteDto));
    }

    public Collection<NoteDto> getAllNotes() {
        return noteRepository.findAll()
                .stream()
                .map(noteMapper::map)
                .collect(Collectors.toList());
    }

    public void updateNote(long noteId, String noteTitle, String noteContent) {
        NoteDto updateNote = noteMapper.map(noteRepository.getOne(noteId));
        updateNote.setNoteTitle(noteTitle);
        updateNote.setNoteContent(noteContent);
        updateNote.setNoteEditionDate(LocalDateTime.now());
        noteRepository.save(noteMapper.reverse(updateNote));
    }

    public void deleteNote(long noteId) {
        noteRepository.findById(noteId).ifPresent(n ->
                noteRepository.delete(n)
        );
    }
}
