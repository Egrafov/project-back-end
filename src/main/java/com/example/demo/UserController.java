package com.example.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
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
    public ResponseEntity<User> postBody(@RequestBody User user) {
        User saved = userRepository.save(user);
        return new ResponseEntity<User>(saved, HttpStatus.CREATED);
    }

//    @PostMapping("/users")
//    public ResponseEntity<User> uploadUser(@RequestBody User user) throws IOException {
////
//        var saved = userRepository.save(user);
//
//        return ResponseEntity.status(HttpStatus.OK).body(saved);
//    }


    @GetMapping("/users")
    @ResponseBody
    public Iterable<User> getAllUsers() {

        for (User p : userRepository.findAll()
        ) {
            System.out.println(p.getUserName());
        }
        return userRepository.findAll();
    }


}

