package pl.pjatk.movie.RestService;

import org.springframework.http.ResponseEntity;
import pl.pjatk.movie.exceptions.MovieNotFoundException;
import pl.pjatk.movie.objects.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class GetLogic {


    private final List<Movie> movieList;

    @Autowired
    public GetLogic(List<Movie> movieList){
        this.movieList = movieList;
    }

    public List<Movie> returnMoviesList(){
        return movieList;
    }
    public Movie returnMovieByID(int id) {
        for (Movie m : movieList){
            if (m.getId() == id){
                return m;
            }
        }

        throw new MovieNotFoundException(id);
    }

}
