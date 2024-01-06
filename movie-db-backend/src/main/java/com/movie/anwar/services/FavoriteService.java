package com.movie.anwar.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movie.anwar.dto.FavoriteRequest;
import com.movie.anwar.entities.Favorite;
import com.movie.anwar.entities.MovieUser;
import com.movie.anwar.repositories.FavoriteRepository;
import com.movie.anwar.repositories.UserRepository;

import jakarta.transaction.Transactional;

@Service
public class FavoriteService {


    @Autowired
    private FavoriteRepository favoriteRepository;
    @Autowired
    private UserRepository userRepository;


    public List<Favorite> getAllfavorite(String username){

        MovieUser user = this.userRepository.findByUserName(username);

        // List<Long> favoriteIds = this.favoriteRepository.findByMovieUser(user)
        // .stream()
        // .map(Favorite::getMovieId)
        // .collect(Collectors.toList());

        return this.favoriteRepository.findByMovieUser(user);
    }
    
    @Transactional
    public void deleteFavorite(Long movieId,String username){
        MovieUser user = this.userRepository.findByUserName(username);
        this.favoriteRepository.deleteByMovieIdAndMovieUser(movieId, user);
    }


    public Favorite getFavorite(Long movieId,String username){
        MovieUser user = this.userRepository.findByUserName(username);
        List<Favorite> favorites= this.favoriteRepository.findByMovieIdAndMovieUser(movieId, user);
        return favorites.get(0);

    }


    public Favorite saveFavorite(FavoriteRequest favoriteRequest){
        MovieUser movieUser = this.userRepository.findByUserName(favoriteRequest.getUsername());
        Favorite favorite = new Favorite(favoriteRequest.getMovieId(),movieUser);
        return this.favoriteRepository.save(favorite);
    }

    public boolean isFavorited(String username, Long filmId) {
        // Implement your logic to check if the movie is favorited by the user
        // This might involve querying a database, checking a cache, etc.
        MovieUser movieUser = this.userRepository.findByUserName(username);
        return favoriteRepository.existsByMovieIdAndMovieUser(filmId, movieUser);
    }
}
