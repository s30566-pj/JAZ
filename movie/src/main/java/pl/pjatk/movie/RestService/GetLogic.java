package pl.pjatk.movie.RestService;

import pl.pjatk.movie.enums.Genre;
import pl.pjatk.movie.exceptions.MovieNotFoundException;
import pl.pjatk.movie.objects.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class GetLogic {


    private List<Movie> movieList;

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

    public int nextFreeId(){
        return movieList.stream().mapToInt(Movie::getId).max().orElse(0)+1;
    }

    public Movie returnNewMovie(String name, String genreName){
        try {
            Genre.valueOf(genreName.toUpperCase());
        } catch (IllegalArgumentException ex){
            throw new RuntimeException("Wrong genre " + genreName);
        }

        return new Movie(nextFreeId(), name, Genre.valueOf(genreName.toUpperCase()));
    }

    public Movie editMovie(int id, Movie movie){ //OMG TO DZIAŁA <33333333
        for (int i = 0; i<movieList.size(); i++){
            if (movieList.get(i).getId() == id){
                movieList.set(i, movie);
                return movieList.get(i);
            }
        }
        throw new RuntimeException("No such movie of id " + id);
    }

    public void deleteExistingMovie(int id){
        boolean removed = movieList.removeIf(m -> m.getId() == id); //usuwanie po predykacie, poszuka obiektu z danym id nie tworząc nowego i go usunie
        if (!removed){
            throw new MovieNotFoundException(id);
        }
    }

}
