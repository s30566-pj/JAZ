package objects;

import enums.Genre;

import java.time.LocalDateTime;

public class Movie {
    private int id;
    private String name;
    private String description;
    private LocalDateTime releaseDate;
    private Genre genre;

    public Movie(int id, String name, String description, LocalDateTime releaseDate, Genre genre) {
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

    public Movie(int id, String name, Genre genre){
        this.id = id;
        this.genre = genre;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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





}
