package ru.monya.firstWebSB.notesSpringBootDatabase;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoteRepository extends JpaRepository<Note,Long> {

    List<Note> findByAuthor(String author);
}
