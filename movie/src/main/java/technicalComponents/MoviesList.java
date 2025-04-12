package technicalComponents;

import enums.Genre;
import objects.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
public class MoviesList {

    public void setMovieList(List<Movie> movieList) {
        this.movieList = movieList;
    }

    private List<Movie> movieList;
    @Autowired
    private Genre genre;

    public MoviesList(){
        this.movieList = new ArrayList<>();
        movieList.add(new Movie(1, "Minecraft Movie", "Just a movie", LocalDateTime.of(2025,4,4, 0, 0), genre.COMEDY));
        movieList.add(new Movie(2, "Titanic", "It drowned.", LocalDateTime.of(1997,12, 19, 0, 0), genre.ROMANTIC));
    }

    public List<Movie> getMovieList() {
        return movieList;
    }




}
