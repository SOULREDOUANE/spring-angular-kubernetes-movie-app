package com.movie.anwar.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movie.anwar.entities.MovieUser;
import com.movie.anwar.repositories.UserRepository;

@Service
public class UserService {

    @Autowired 
    private UserRepository userRepository;
    

    public boolean authenticateUser(String username, String password) {
        MovieUser filmUser = userRepository.findByUserName(username);

        if (filmUser == null) {
            return false;
        } else {
            if (filmUser.getPassword().equals(password)) {
                return true;
            }
            return false;
        }
    }
    
}
