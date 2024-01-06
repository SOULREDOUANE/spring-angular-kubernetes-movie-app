package com.movie.anwar.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movie.anwar.dto.CommentaireRequest;
import com.movie.anwar.entities.Commentaire;
import com.movie.anwar.entities.MovieUser;
import com.movie.anwar.repositories.CommentaireRepository;
import com.movie.anwar.repositories.UserRepository;

@Service
public class CommentaireService {

    @Autowired 
    private UserRepository userRepository;

    @Autowired 
    private CommentaireRepository commentaireRepository;



    public Commentaire saveCommentaire(CommentaireRequest commentaireRequest ){
        MovieUser movieUser = this.userRepository.findByUserName(commentaireRequest.getUsername());
        Commentaire commentaire = new Commentaire(commentaireRequest.getContent(),commentaireRequest.getMovieId(),movieUser);
        return this.commentaireRepository.save(commentaire);
    }

    public List<Commentaire> findAllCommentaire(Long movieId,String username){
        MovieUser movieUser = this.userRepository.findByUserName(username);

        return this.commentaireRepository.findByMovieIdAndMovieUser(movieId, movieUser);
    }

    
}
