package com.movie.anwar.authentication;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.movie.anwar.entities.MovieUser;
import com.movie.anwar.repositories.UserRepository;
import com.movie.anwar.services.UserService;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(path = "api/v1/register",
                produces="application/json"
)
@CrossOrigin(origins = "*")
public class RegistrationController {
    private final Logger logger = LoggerFactory.getLogger(RegistrationController.class);
    private final UserRepository userRepository;
    private final UserService userService;


    public RegistrationController(UserRepository userRepository, UserService userService) {
        this.userRepository = userRepository;
        this.userService= userService;
    }


    @PostMapping(path = "/login", consumes="application/json")
    public ResponseEntity<Map<String, Object>> login(@RequestBody MovieUser credentials) {
        String username = credentials.getUserName();
        String password = credentials.getPassword();


        // Check credentials against the database
        boolean authenticated = userService.authenticateUser(username, password);
        logger.info("User logging in : {}", username + " Status :" + authenticated);

        Map<String, Object> response = new HashMap<>();
        if (authenticated) {
            response.put("success", true);
        } else {
            response.put("success", false);
        }

        return ResponseEntity.ok(response);
    }

    @PostMapping(consumes="application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public  MovieUser processRegistration(@RequestBody MovieUser movieUser) {
        return userRepository.save(movieUser);
    }
    
}
