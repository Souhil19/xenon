package dev.somari.xenon.movie;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class MovieRepository {
    private List <Movie> movies= new ArrayList<>();

    List<Movie> findAll(){
        return movies;
    }

    Optional<Movie> findById(Integer id){
        return movies.stream().filter(movie -> movie.id().equals(id)).findFirst();
    }

    void create(Movie movie){
        movies.add(movie);
    }

    void update(Movie movie, Integer id){
        Optional<Movie> mv= findById(movie.id());
        if (mv.isPresent()){
            movies.set(movies.indexOf(mv.get()), movie);
        }
    }

    void delete(Integer id){
        Optional<Movie> mv= findById(id);
        if (mv.isPresent()){
            movies.remove(mv.get());
        }
    }

    @PostConstruct
    private void init(){
        movies.add(new Movie(1,"Squid Game", LocalDateTime.now(),LocalDateTime.now().plusHours(2),2));
        movies.add(new Movie(3,"Fast & Furious", LocalDateTime.now(),LocalDateTime.now().plusHours(3),6));
    }
}
