package pl.pjatk.movie.objects;

import jakarta.persistence.*;
import pl.pjatk.movie.enums.Genre;

import java.time.LocalDateTime;

@Entity
@Table(name = "movies")
public class Movie {
    @Id
    @Column
    private Long id;
    @Column
    private String name;
    @Column
    private String description;
    @Column
    private LocalDateTime releaseDate;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Genre genre;
    @Column
    private boolean isAvailable = false;

    public Movie(){}

    public Movie(Long id, String name, String description, LocalDateTime releaseDate, Genre genre, boolean isAvailable) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.releaseDate = releaseDate;
        this.genre = genre;
        this.isAvailable=isAvailable;
    }

    public Movie(Long id, String name, String description, LocalDateTime releaseDate, Genre genre) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.releaseDate = releaseDate;
        this.genre = genre;
    }

    public Movie(String name, String description, LocalDateTime releaseDate, Genre genre) {
        this.name = name;
        this.description = description;
        this.releaseDate = releaseDate;
        this.genre = genre;
    }

    public Movie(String name, LocalDateTime releaseDate, Genre genre) {
        this.name = name;
        this.releaseDate = releaseDate;
        this.genre = genre;
    }

    public Movie(Long id, String name, Genre genre){
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
