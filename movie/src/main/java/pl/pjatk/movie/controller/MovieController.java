package pl.pjatk.movie.controller;

import org.springframework.web.bind.annotation.PathVariable;
import pl.pjatk.movie.RestService.GetLogic;
import pl.pjatk.movie.objects.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MovieController {

    private final GetLogic getLogic;

    @Autowired
    public MovieController(GetLogic getLogic){
        this.getLogic = getLogic;
    }

    @GetMapping("/movies")
    public ResponseEntity<List<Movie>> returnMoviesList(){
        return ResponseEntity.ok(getLogic.returnMoviesList());
    }

    @GetMapping("/movies/{id}")
    public ResponseEntity<Movie> getMovieById(@PathVariable("id") int id){
        return ResponseEntity.ok(getLogic.returnMovieByID(id));
    }
}
