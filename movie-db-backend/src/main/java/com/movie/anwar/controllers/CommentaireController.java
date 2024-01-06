package com.movie.anwar.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.movie.anwar.dto.CommentaireRequest;
import com.movie.anwar.entities.Commentaire;

import com.movie.anwar.services.CommentaireService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/v1/commentaire")
public class CommentaireController {

    @Autowired 
    private CommentaireService commentaireService;



    @PostMapping("save")
    public Commentaire saveCommentaire(@RequestBody CommentaireRequest commentaireRequest){
        return this.commentaireService.saveCommentaire(commentaireRequest);
    }

    @GetMapping("all/{movieId}/{username}")
    public List<Commentaire> getAllCommentaire(@PathVariable Long movieId,@PathVariable String username){
        return this.commentaireService.findAllCommentaire(movieId, username);
    }
    
    
    
}
