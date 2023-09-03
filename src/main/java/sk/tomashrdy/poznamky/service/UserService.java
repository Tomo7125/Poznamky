package sk.tomashrdy.poznamky.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import sk.tomashrdy.poznamky.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;  // Pridanie PasswordEncoder

    // Metóda na registráciu nového používateľa
    public User registerUser(User user) {
        // Zakódovanie hesla pred uložením
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    // Metóda na vyhľadávanie používateľa podľa mena
    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    // Metóda na kontrolu, či používateľ s daným menom už existuje
    public boolean userExists(String username) {
        return userRepository.existsByUsername(username);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    // Pridané metódy
    public List<User> findAll() {
        return userRepository.findAll();
    }

    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public User update(Long id, User user) {
        if(userRepository.existsById(id)) {
            user.setId(id);
            return userRepository.save(user);
        }
        return null; // alebo môžete vyvolať výnimku
    }

    public void delete(Long id) {
        userRepository.deleteById(id);
    }
}