package pl.pjatk.RentalService.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import pl.pjatk.RentalService.model.Movie;
import pl.pjatk.RentalService.service.MovieService;

import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@RestController
@RequestMapping("/api")
public class MovieController {

    private MovieService movieService;

    public MovieController(MovieService movieService){
        this.movieService = movieService;
    }

    @GetMapping("/movie/{id}")
    public ResponseEntity<Movie> getMovie(@PathVariable("id") Long id){
        Movie movie = movieService.fetchMovieByID(id);
        return ResponseEntity.ok(movie);
    }

    @GetMapping("/movies/{id}/return")
    public ResponseEntity<Void> returnMovie(@PathVariable Long id) {
        movieService.returnMovie(id);
        return ResponseEntity.noContent().build();
    }

}
