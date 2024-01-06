package com.movie.anwar.dto;

public class FavoriteRequest {
    
    private Long movieId;
    private String username;



    public FavoriteRequest(){}
    public FavoriteRequest(Long movieId, String username) {
        this.movieId = movieId;
        this.username = username;
    }
    public Long getMovieId() {
        return movieId;
    }
    public void setMovieId(Long movieId) {
        this.movieId = movieId;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }




    

}
