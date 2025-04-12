package RestService;

import objects.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import technicalComponents.MoviesList;

import java.util.List;


@Service
public class GetLogic {

    @Autowired
    private MoviesList moviesList;

    public List<Movie> returnMoviesList(){
        return moviesList.getMovieList();
    }
}
