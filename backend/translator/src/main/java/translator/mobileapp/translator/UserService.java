package translator.mobileapp.translator;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // do not want to create a user if they do not have a username or password calling our userRepository field
    public User createUser(User newUser) {
        if ((newUser.getPassword() == null) || (newUser.getUsername() == null)) {
            return null;
        }

        return userRepository.save(newUser);
    }

    public boolean deleteUser(Long id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    public Optional<User> findUserByUsernamePassword(String username, String password) {
        try {
            return userRepository.findByUsernameAndPassword(username, password);
        } catch (Exception e) {
            throw new RuntimeException("Unable to find a user with the username: " + username);
        }
    }

    public Optional<User> findUserById(Long id) {
        if (userRepository.existsById(id)) {
            return userRepository.findById(id);
        } else {
            return Optional.empty();
        }
    }
}