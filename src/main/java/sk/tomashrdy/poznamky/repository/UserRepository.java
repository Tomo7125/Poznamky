package sk.tomashrdy.poznamky.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sk.tomashrdy.poznamky.model.User;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    // Vyhľadá používateľa podľa mena (už máte)
    Optional<User> findByUsername(String username);

    // Skontroluje, či používateľ s daným menom už existuje
    boolean existsByUsername(String username);

    // V prípade, že by ste chceli podporovať prihlásenie pomocou e-mailu
    Optional<User> findByEmail(String email);
    boolean existsByEmail(String email);
}