package com.domnyus.todo.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private IUserRepository userRepository;

    @PostMapping("/")
    public ResponseEntity Create(@RequestBody UserModel userModel) {
        var result = this.userRepository.findByUsername(userModel.getUsername());

        if (result != null) {
            System.out.println("User not unique");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User already exists!");
        }
        var userCreated = this.userRepository.save(userModel);

        return ResponseEntity.status(HttpStatus.CREATED).body(userModel);
    }
}
