package pl.pjatk.movie.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
import pl.pjatk.movie.RestService.GetLogic;
import pl.pjatk.movie.objects.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

@RestController
@Tag(name = "Movies", description = "Endpoints for managing movies")
public class MovieController {

    private final GetLogic getLogic;

    @Autowired
    public MovieController(GetLogic getLogic){
        this.getLogic = getLogic;
    }

    @Operation(summary = "Get all movies", description = "Returns list of all movies")
    @GetMapping("/movies")
    public ResponseEntity<List<Movie>> returnMoviesList(){
        return ResponseEntity.ok(getLogic.returnMoviesList());
    }

    @GetMapping("/movies/{id}")
    public ResponseEntity<Movie> getMovieById(@PathVariable("id") Long id){
        return ResponseEntity.ok(getLogic.returnMovieByID(id));
    }

    @PostMapping("/movies")
    public ResponseEntity<Movie> createNewMovie(@RequestBody(required = true) Map<String, String> body){ // Nie mogłem podać dwóch osobnych Stringów, to użyłem mapy, działa lol
        return ResponseEntity.ok(getLogic.returnNewMovie(body.get("name"), body.get("genre")));
    }

    @PutMapping("/movies/{id}")
    public ResponseEntity<Movie> editExistingMovie(@RequestBody(required = true) Movie movie, @PathVariable("id") Long id){
        return ResponseEntity.ok(getLogic.editMovie(id, movie));
    }

    @DeleteMapping("/movies/{id}")
    public ResponseEntity<Void> deleteExistingMovie(@PathVariable("id") Long id){
        getLogic.deleteExistingMovie(id);
        return ResponseEntity.noContent().build();
    }

//    @GetMapping("/movies/avail/{id}")
//    public ResponseEntity<Movie> createNewMovie(@PathVariable("id") Long id){
//        getLogic.changeIsAvailable(id);
//        return
//    }

}
