package com.movie.anwar;

import com.movie.anwar.entities.Commentaire;
import com.movie.anwar.entities.Favorite;
import com.movie.anwar.entities.MovieUser;
import com.movie.anwar.repositories.CommentaireRepository;
import com.movie.anwar.repositories.FavoriteRepository;
import com.movie.anwar.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
// import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AnwarApplication {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private FavoriteRepository favoriteRepository;

    @Autowired
    private CommentaireRepository commentaireRepository;

    public static void main(String[] args) {
        SpringApplication.run(AnwarApplication.class, args);
    }

    @Bean
    public CommandLineRunner initializeData() {
        return args -> {
            MovieUser movieUser = new MovieUser("redouane","redouane");
            userRepository.save(movieUser);

            Favorite favorite1 = new Favorite(572802L, movieUser);
            Favorite favorite2 = new Favorite( 872585L, movieUser);
            Favorite favorite3 = new Favorite(695721L, movieUser);
            favoriteRepository.save(favorite1);
            favoriteRepository.save(favorite2);
            favoriteRepository.save(favorite3);
			// -------------
            Commentaire commentaire = new Commentaire("i like it",572802L,movieUser);
            Commentaire commentaire1= new Commentaire("it is not good",572802L,movieUser);
            Commentaire commentaire2 = new Commentaire("it the best i've ever watched",232L,movieUser);
            commentaireRepository.save(commentaire);
            commentaireRepository.save(commentaire1);
            commentaireRepository.save(commentaire2);
        };
    }
}
