package pl.pjatk.movie.exceptions;

public class MovieNotFoundException extends RuntimeException{
    public MovieNotFoundException(Long id) {
        super("Film o ID " + id + " nie istnieje");
    }
}
