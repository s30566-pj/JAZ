package controller;

import RestService.GetLogic;
import objects.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MovieController {

    private GetLogic getLogic;

    @Autowired
    public MovieController(GetLogic getLogic){
        this.getLogic = getLogic;
    }

    @GetMapping("/movies")
    public ResponseEntity<List<Movie>> returnMoviesList(){
        return ResponseEntity.ok(getLogic.returnMoviesList());
    }
}
