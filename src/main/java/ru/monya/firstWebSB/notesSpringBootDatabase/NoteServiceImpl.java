package ru.monya.firstWebSB.notesSpringBootDatabase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class NoteServiceImpl implements NoteService {

    private final NoteRepository repository;

    @Autowired
    public NoteServiceImpl(NoteRepository repository) {
        this.repository = repository;
    }

    //Капец, я затупил,- методы ничего не возвращают, а понять не могу почему из базы данные не считываются
    @Override
    public List<Note> getAllNotes() {
        return repository.findAll();
    }


    @Override
    public Note findNoteById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Note createNote(Note note) {

        return repository.save(note);
    }

    @Override
    public Note updateNote(Long id, Note note) {
        note.setId(id);
        return (repository.save(note));
    }

    @Override
    public void deleteNote(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<Note> findByAuthor(String author) {
        return repository.findByAuthor(author);
    }


}
