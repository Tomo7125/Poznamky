package sk.tomashrdy.poznamky.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sk.tomashrdy.poznamky.model.Note;

import java.util.List;

@Repository
public interface NoteRepository extends JpaRepository<Note, Long> {
    // Example custom query
    List<Note> findByTitleContaining(String keyword);
}