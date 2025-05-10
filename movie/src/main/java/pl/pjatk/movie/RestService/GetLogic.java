package pl.pjatk.movie.RestService;

import pl.pjatk.movie.enums.Genre;
import pl.pjatk.movie.exceptions.MovieNotFoundException;
import pl.pjatk.movie.objects.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
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

    public Movie editMovie(int id, Movie movie){
        try {
            returnMovieByID(id);
        } catch (MovieNotFoundException ex){
            throw new RuntimeException("No such movie of id " + id);
        }

        Movie existing = returnMovieByID(id);
        existing.setName(movie.getName());
        existing.setDescription(movie.getDescription());
        existing.setReleaseDate(movie.getReleaseDate());
        existing.setGenre(movie.getGenre());
        // Nie podobało mi się jak było wcześniej, spędziłem z ponad pół godziny bo podmiana elementu w liście po indexie powodowała zwracanie nulla...
        return existing;

    }


}
