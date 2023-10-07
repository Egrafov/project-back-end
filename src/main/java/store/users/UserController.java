package store.users;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @DeleteMapping("/users/{userName}")
    public ResponseEntity<Void> deleteUser(@PathVariable String userName) {
        if (userRepository.existsById(userName)) {
            userRepository.deleteById(userName);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/users")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        if (userRepository.findById(user.getUserName()).isPresent()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
        User saved = userRepository.save(user);
        return new ResponseEntity<User>(saved, HttpStatus.CREATED);
    }

    @PostMapping("/users/login")
    public ResponseEntity<Object> postBody(@RequestBody LoginCredentials credentials) {
        var optionalUser = userRepository.findById(credentials.userName);
        if (optionalUser.isEmpty()) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("User does not exist. Please register.");
        }
        var storedHash = optionalUser.get().getHashPassword();
        var salt = optionalUser.get().getSalt();

        var hashRes = BCrypt.hashpw(credentials.password, salt);
        if (!hashRes.equals(storedHash)) {
            ResponseEntity.status(HttpStatus.FORBIDDEN).body("Wrong credentials");
        }

        var user = optionalUser.get();
        Login loginUser = new Login(user.getAddress(), user.getFirstName(), user.isAdmin());
        return ResponseEntity.status(HttpStatus.OK).body(loginUser);
    }

    @GetMapping("/users")
    @ResponseBody
    public Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }
}

