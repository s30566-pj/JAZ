package pl.pjatk.movie.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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
    public MovieController(GetLogic getLogic) {
        this.getLogic = getLogic;
    }

    @Operation(summary = "Get all movies", description = "Returns list of all movies")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "List of movies returned successfully"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @GetMapping("/movies")
    public ResponseEntity<List<Movie>> returnMoviesList() {
        return ResponseEntity.ok(getLogic.returnMoviesList());
    }

    @Operation(summary = "Get movie by ID", description = "Returns a single movie by its ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Movie found"),
            @ApiResponse(responseCode = "404", description = "Movie not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @GetMapping("/movies/{id}")
    public ResponseEntity<Movie> getMovieById(
            @Parameter(description = "ID of the movie to retrieve") @PathVariable("id") Long id) {
        return ResponseEntity.ok(getLogic.returnMovieByID(id));
    }

    @Operation(summary = "Create new movie", description = "Creates a new movie using name and genre")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Movie created successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid input data"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @PostMapping("/movies")
    public ResponseEntity<Movie> createNewMovie(
            @Parameter(description = "Map with keys 'name' and 'genre'")
            @RequestBody(required = true) Map<String, String> body) {
        return ResponseEntity.ok(getLogic.returnNewMovie(body.get("name"), body.get("genre")));
    }

    @Operation(summary = "Edit existing movie", description = "Updates a movie by its ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Movie updated successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid movie data"),
            @ApiResponse(responseCode = "404", description = "Movie not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @PutMapping("/movies/{id}")
    public ResponseEntity<Movie> editExistingMovie(
            @Parameter(description = "Movie object with updated fields") @RequestBody(required = true) Movie movie,
            @Parameter(description = "ID of the movie to update") @PathVariable("id") Long id) {
        return ResponseEntity.ok(getLogic.editMovie(id, movie));
    }

    @Operation(summary = "Delete movie", description = "Deletes a movie by its ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Movie deleted successfully"),
            @ApiResponse(responseCode = "404", description = "Movie not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @DeleteMapping("/movies/{id}")
    public ResponseEntity<Void> deleteExistingMovie(
            @Parameter(description = "ID of the movie to delete") @PathVariable("id") Long id) {
        getLogic.deleteExistingMovie(id);
        return ResponseEntity.noContent().build();
    }
}
