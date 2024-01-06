package com.movie.anwar.entities;

import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Component
@Entity
@Table(name = "movie_user") 
public class MovieUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    @Column(name="movie_user")
    private Long user;
    @Column(nullable = false,unique = true)
    private String userName;
    
    // @Column(nullable = false,unique = true)
    private String password;

    
    public MovieUser(){}

    public MovieUser(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }
    


    public String getUserName() {
        return userName;
    }


    public void setUserName(String userName) {
        this.userName = userName;
    }


    public String getPassword() {
        return password;
    }


    public void setPassword(String password) {
        this.password = password;
    }

    


    
}
