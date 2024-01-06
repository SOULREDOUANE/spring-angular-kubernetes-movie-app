package com.movie.anwar.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.movie.anwar.entities.Commentaire;
import java.util.List;
import com.movie.anwar.entities.MovieUser;


public interface CommentaireRepository extends JpaRepository<Commentaire,Long> {

    List<Commentaire> findByMovieIdAndMovieUser(Long movieId, MovieUser movieUser);
    
}