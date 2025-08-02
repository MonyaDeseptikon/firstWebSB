package ru.monya.firstWebSB.notesSpringBootDatabase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notes")
@CrossOrigin(origins = "*")
//@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.OPTIONS})
public class NoteController {

    private final NoteService service;
    @Autowired
    public NoteController(NoteService service) {
        this.service = service;
    }

    @GetMapping
    public List<Note> findAll() {
        return service.getAllNotes();
    }

    @GetMapping("/{id:\\d+}")
    public Note findNoteById(@PathVariable Long id) {
        return service.findNoteById(id);
    }

    @GetMapping("/{author:.*\\D.*}")
    public List<Note> findNoteByAuthor(@PathVariable String author) {
        return service.findByAuthor(author);
    }

    @PostMapping

    public Note save(@RequestBody Note note) {
        return service.createNote(note);
    }

    @PutMapping("/{id}")
    public Note updateNote(@PathVariable Long id, @RequestBody Note note) {
        return service.updateNote(id, note);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        service.deleteNote(id);
    }

}
