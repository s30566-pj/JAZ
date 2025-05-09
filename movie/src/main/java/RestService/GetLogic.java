package RestService;

import objects.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import technicalComponents.MoviesList;

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
}
