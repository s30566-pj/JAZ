package pl.pjatk.movie.controller;

import org.springframework.web.bind.annotation.*;
import pl.pjatk.movie.RestService.GetLogic;
import pl.pjatk.movie.objects.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

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

    @PostMapping("/movies")
    public ResponseEntity<Movie> createNewMovie(@RequestBody(required = true) Map<String, String> body){ // Nie mogłem podać dwóch osobnych Stringów, to użyłem mapy, działa lol
        return ResponseEntity.ok(getLogic.returnNewMovie(body.get("name"), body.get("genre")));
    }

    @PutMapping("/movies/{id}")
    public ResponseEntity<Movie> editExistingMovie(@RequestBody(required = true) Movie movie, @PathVariable("id") int id){
        return ResponseEntity.ok(getLogic.editMovie(id, movie));
    }

}
