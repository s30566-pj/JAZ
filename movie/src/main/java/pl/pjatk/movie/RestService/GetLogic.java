package pl.pjatk.movie.RestService;

import ch.qos.logback.core.model.processor.ModelHandlerException;
import pl.pjatk.movie.enums.Genre;
import pl.pjatk.movie.exceptions.MovieNotFoundException;
import pl.pjatk.movie.interfaces.MovieRepository;
import pl.pjatk.movie.objects.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class GetLogic {


    private List<Movie> movieList;
    public final MovieRepository movieRepository;

    @Autowired
    public GetLogic(List<Movie> movieList, MovieRepository movieRepository){
        this.movieList = movieList;
        this.movieRepository = movieRepository;
    }

    public List<Movie> returnMoviesList(){
        return movieList;
    }
    public Movie returnMovieByID(Long id) {
        for (Movie m : movieList){
            if (m.getId() == id){
                return m;
            }
        }

        throw new MovieNotFoundException(id);
    }

    public int nextFreeId(){
        return (int) (movieList.stream().mapToLong(Movie::getId).max().orElse(0)+1);
    }

    public Movie returnNewMovie(String name, String genreName){
        try {
            Genre.valueOf(genreName.toUpperCase());
        } catch (IllegalArgumentException ex){
            throw new RuntimeException("Wrong genre " + genreName);
        }

        return new Movie(Long.valueOf(nextFreeId()), name, Genre.valueOf(genreName.toUpperCase()));
    }

    public Movie editMovie(Long id, Movie movie){ //OMG TO DZIAŁA <33333333
        for (int i = 0; i<movieList.size(); i++){
            if (movieList.get(i).getId() == id){
                movieList.set(i, movie);
                return movieList.get(i);
            }
        }
        throw new RuntimeException("No such movie of id " + id);
    }

    public void deleteExistingMovie(Long id){
        boolean removed = movieList.removeIf(m -> m.getId() == id); //usuwanie po predykacie, poszuka obiektu z danym id nie tworząc nowego i go usunie
        if (!removed){
            throw new MovieNotFoundException(id);
        }
    }

    public Movie findById(Long id) throws ModelHandlerException {
        return movieRepository.findById(id).orElseThrow(ModelHandlerException::new);
    }

}
