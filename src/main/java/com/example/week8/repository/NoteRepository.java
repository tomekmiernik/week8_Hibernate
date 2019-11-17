package com.example.week8.repository;

import com.example.week8.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface NoteRepository extends JpaRepository<Note, Long> {

    @Query("select n from Note n where n.noteId=?1")
    Optional<Note> getNoteByNoteId(long noteId);

}
