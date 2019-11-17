package com.example.week8.service;

import com.example.week8.dto.NoteDto;
import com.example.week8.model.Note;
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
        noteDto.setNoteCreationDate(LocalDateTime.now());
        noteRepository.save(noteMapper.reverse(noteDto));
    }

    public Collection<NoteDto> getAllNotes() {
        return noteRepository.findAll()
                .stream()
                .map(noteMapper::map)
                .collect(Collectors.toList());
    }

    public void updateNote(NoteDto noteDto) {
        noteRepository.getNoteByNoteId(noteDto.getNoteId())
                .ifPresent(n -> {
                    n.setNoteTitle(noteDto.getNoteTitle());
                    n.setNoteContent(noteDto.getNoteContent());
                    n.setNoteEditionDate(LocalDateTime.now());
                    noteRepository.save(n);
                });
    }

    public void deleteNote(long noteId) {
        noteRepository.findById(noteId).ifPresent(n ->
                noteRepository.delete(n)
        );
    }

    public NoteDto getNodeById(long noteId) {
        Note getNote = noteRepository.getOne(noteId);
        return noteMapper.map(getNote);
    }
}
