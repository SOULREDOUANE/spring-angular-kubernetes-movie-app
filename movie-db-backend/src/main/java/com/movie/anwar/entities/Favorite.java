package com.movie.anwar.entities;

import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Component
@Entity
public class Favorite {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)

    private Long favoriteId;

    private Long movieId;
    


    @ManyToOne()
    private MovieUser movieUser;




    public Favorite(Long movieId, MovieUser movieUser) {
        this.movieId = movieId;
        
        this.movieUser = movieUser;
    }



    public Favorite(){}







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
