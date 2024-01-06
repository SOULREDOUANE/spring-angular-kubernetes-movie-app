package com.movie.anwar.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.movie.anwar.entities.MovieUser;



@Repository
public interface UserRepository extends JpaRepository<MovieUser,Long>{
    
    MovieUser findByUserName(String userName);
    
}
