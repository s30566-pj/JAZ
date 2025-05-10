package pl.pjatk.movie.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.pjatk.movie.objects.Movie;

import java.util.Optional;

public interface MovieRepository extends JpaRepository<Movie, Long> {
    Optional<Movie> findBy(Long id);
}
