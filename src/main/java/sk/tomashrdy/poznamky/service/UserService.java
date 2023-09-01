package sk.tomashrdy.poznamky.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.tomashrdy.poznamky.model.User;
import sk.tomashrdy.poznamky.repository.UserRepository;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(Long id) {
        return userRepository.findById(id).orElse(null);
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

    // Add other methods as needed...
}