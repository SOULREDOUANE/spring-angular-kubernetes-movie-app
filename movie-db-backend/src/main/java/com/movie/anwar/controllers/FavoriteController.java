package com.movie.anwar.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.movie.anwar.dto.FavoriteRequest;
import com.movie.anwar.entities.Favorite;

import com.movie.anwar.services.FavoriteService;


@RestController
@RequestMapping("api/v1/favorite")
@CrossOrigin(origins = "*")
public class FavoriteController {

    @Autowired
    private FavoriteService favoriteService;
    


    @GetMapping("all/{username}")
    public List<Favorite> getAllfavorite(@PathVariable String username) {
        return this.favoriteService.getAllfavorite(username);
    }
    

    @DeleteMapping("delete/{movieId}/{username}")
    public void deletefavorite(@PathVariable Long movieId, @PathVariable String username){
        this.favoriteService.deleteFavorite(movieId, username);
    }

    @GetMapping("{movieId}/{username}")
    public Favorite getfavoriteById(@PathVariable Long movieId, @PathVariable String username){
        return this.favoriteService.getFavorite(movieId,username);
    }

    @PostMapping("save")
    public Favorite saveFavorite(@RequestBody FavoriteRequest favoriteRequest){
        return favoriteService.saveFavorite(favoriteRequest);
    }

    @CrossOrigin(origins = "*")
    @GetMapping("exist/{filmId}/{username}")
    public Boolean estFavorise(
            @PathVariable Long filmId,
            @PathVariable String username) {
        // Call the appropriate method from FavoriteService to check if it's favorited
        return favoriteService.isFavorited(username, filmId);
    }

    
}
