package com.movie.anwar.dto;

public class CommentaireRequest {
    

    private String content;
    private Long movieId;
    private String username;


    
    public CommentaireRequest(String content, Long movieId, String username) {
        this.content = content;
        this.movieId = movieId;
        this.username = username;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
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
