package dev.somari.xenon.movie;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

import static org.springframework.http.HttpStatusCode.*;

@RestController
@RequestMapping("/api/movies")
public class MovieController {

    private final MovieRepository movieRepository;

    public MovieController(MovieRepository movieRepository){
        this.movieRepository = movieRepository;
    }

    @GetMapping("")
    List<Movie> findAll(){
        return movieRepository.findAll();
    }

    @GetMapping("/{id}")
    Movie findById(@PathVariable Integer id){
        Optional<Movie> mv= movieRepository.findById(id);
        if (mv.isPresent()){
            return mv.get();
        } else throw new MovieNotFoundException();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    void create(@Valid @RequestBody Movie movie){
        movieRepository.create(movie);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    void update(@Valid @RequestBody Movie movie, @PathVariable Integer id){
        movieRepository.update(movie, id);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    void delete(@PathVariable Integer id){
        movieRepository.delete(id);
    }


}
