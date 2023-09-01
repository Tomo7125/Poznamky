package sk.tomashrdy.poznamky.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.tomashrdy.poznamky.model.Note;
import sk.tomashrdy.poznamky.repository.NoteRepository;

import java.util.List;

@Service
public class NoteService {

    @Autowired
    private NoteRepository noteRepository;

    public List<Note> getAllNotes() {
        return noteRepository.findAll();
    }

    public Note getNoteById(Long id) {
        return noteRepository.findById(id).orElse(null);
    }

    public List<Note> findAll() {
        return noteRepository.findAll();
    }

    public Note findById(Long id) {
        return noteRepository.findById(id).orElse(null);
    }

    public Note save(Note note) {
        return noteRepository.save(note);
    }

    public Note update(Long id, Note note) {
        if(noteRepository.existsById(id)) {
            note.setId(id);
            return noteRepository.save(note);
        }
        return null; // alebo môžete vyvolať výnimku
    }

    public void delete(Long id) {
        noteRepository.deleteById(id);
    }
    // Add other methods as needed...
}