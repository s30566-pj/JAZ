package pl.pjatk.movie.objects;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import pl.pjatk.movie.enums.Genre;

import java.time.LocalDateTime;

@Entity
@Table(name = "movies")
@Schema(description = "Movie entity representing a film with metadata")
public class Movie {

    @Id
    @Column
    @Schema(description = "Unique identifier of the movie", example = "1", accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;

    @Column
    @Schema(description = "Title of the movie", example = "Inception", required = true)
    private String name;

    @Column
    @Schema(description = "Short description or synopsis of the movie", example = "A thief who steals corporate secrets through the use of dream-sharing technology.")
    private String description;

    @Column
    @Schema(description = "Date and time the movie was released", example = "2024-12-01T15:30:00")
    private LocalDateTime releaseDate;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    @Schema(description = "Genre of the movie", example = "ACTION", required = true)
    private Genre genre;

    @Column
    @Schema(description = "Availability status of the movie", example = "true")
    private boolean isAvailable = false;

    public Movie() {}

    public Movie(Long id, String name, String description, LocalDateTime releaseDate, Genre genre, boolean isAvailable) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.releaseDate = releaseDate;
        this.genre = genre;
        this.isAvailable = isAvailable;
    }

    public Movie(Long id, String name, String description, LocalDateTime releaseDate, Genre genre) {
        this(id, name, description, releaseDate, genre, false);
    }

    public Movie(String name, String description, LocalDateTime releaseDate, Genre genre) {
        this(null, name, description, releaseDate, genre, false);
    }

    public Movie(String name, LocalDateTime releaseDate, Genre genre) {
        this.name = name;
        this.releaseDate = releaseDate;
        this.genre = genre;
    }

    public Movie(Long id, String name, Genre genre) {
        this.id = id;
        this.genre = genre;
        this.name = name;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDateTime releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
}
