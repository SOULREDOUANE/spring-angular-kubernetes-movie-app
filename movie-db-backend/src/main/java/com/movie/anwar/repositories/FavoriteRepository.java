package com.movie.anwar.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.movie.anwar.entities.Favorite;
import com.movie.anwar.entities.MovieUser;

import java.util.List;


public interface FavoriteRepository extends JpaRepository<Favorite,Long> {

    List<Favorite> findByMovieUser(MovieUser movieUser);
    @Override
    void deleteById(Long id) ;
    void deleteByMovieIdAndMovieUser(Long movieId, MovieUser movieUser);
    List<Favorite> findByMovieIdAndMovieUser(Long movieId, MovieUser movieUser);
    boolean existsByMovieIdAndMovieUser(Long movieId, MovieUser movieUser);
    
    
} 