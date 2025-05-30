package pl.pjatk.movie.technicalComponents;

import pl.pjatk.movie.enums.Genre;
import pl.pjatk.movie.objects.Movie;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class MoviesList {

    @Bean
    public List<Movie> movieList(){
        return new ArrayList<>(List.of(
            new Movie(1L, "Minecraft Movie", "Just a movie", LocalDateTime.of(2025,4,4, 0, 0), Genre.COMEDY),
            new Movie(2L, "Titanic", "It drowned.", LocalDateTime.of(1997,12, 19, 0, 0), Genre.ROMANTIC)
        ));
    }



}
