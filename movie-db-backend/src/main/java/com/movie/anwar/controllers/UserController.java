package com.movie.anwar.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.movie.anwar.entities.MovieUser;
import com.movie.anwar.repositories.UserRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@CrossOrigin(origins="*")
@RequestMapping("api/v1/user")
public class UserController {
    
    @Autowired
    private UserRepository userRepository;


    @PostMapping("save")
    public MovieUser saveUser(@RequestBody MovieUser movieUser){
        return this.userRepository.save(movieUser);
    }
    

    @GetMapping("/{username}")

    public MovieUser getUserByUsername(@PathVariable String username){
        return this.userRepository.findByUserName(username);
        

    }

    
}
