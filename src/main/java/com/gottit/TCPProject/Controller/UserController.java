package com.gottit.TCPProject.Controller;

import com.gottit.TCPProject.Model.User;
import com.gottit.TCPProject.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {


    @Autowired
    UserRepository userRepository;

    @PostMapping
    public ResponseEntity<User> create(@RequestBody User user){

        return new ResponseEntity(userRepository.save(user), HttpStatus.OK);
    }
    @GetMapping("/{user_name}")
    public ResponseEntity<User> show(@PathVariable String user_name){
        return new ResponseEntity(userRepository.findAllByUsername(user_name),HttpStatus.OK);
    }


}
