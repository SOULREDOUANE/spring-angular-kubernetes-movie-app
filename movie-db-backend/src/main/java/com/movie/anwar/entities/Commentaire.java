package com.movie.anwar.entities;

import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Component
@Entity
public class Commentaire {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String content;

    private Long movieId;

    @ManyToOne(fetch = FetchType.LAZY)
    private MovieUser movieUser;


    

    public Commentaire(String content,Long movieId, MovieUser movieUser) {
        this.content = content;
        this.movieUser = movieUser;
        this.movieId=movieId;
    }

    public Commentaire(){}

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public MovieUser getMovieUser() {
        return movieUser;
    }

    public void setMovieUser(MovieUser movieUser) {
        this.movieUser = movieUser;
    }

    public Long getMovieId() {
        return movieId;
    }

    public void setMovieId(Long movieId) {
        this.movieId = movieId;
    }

    



    
    
}
