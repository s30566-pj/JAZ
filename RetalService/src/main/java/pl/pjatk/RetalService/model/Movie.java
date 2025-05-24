package pl.pjatk.RetalService.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import org.springframework.data.annotation.Id;
import pl.pjatk.RetalService.enums.Genre;

import java.time.LocalDateTime;

@Entity
public class Movie {
    @jakarta.persistence.Id
    @Id
    private Long id;
    private String name;
    private String description;
    private LocalDateTime releaseDate;
    private Genre genre;

    public Movie(){}

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
}

