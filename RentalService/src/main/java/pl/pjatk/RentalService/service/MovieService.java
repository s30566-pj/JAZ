package pl.pjatk.RentalService.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.pjatk.RentalService.model.Movie;

@Service
public class MovieService {

    private final RestTemplate restTemplate;

    public MovieService(RestTemplate restTemplate){this.restTemplate = restTemplate;}

    public Movie fetchMovieByID(Long id){
        String url = "localhost:8080/movies/{id}";
        return restTemplate.getForObject(url, Movie.class, id);
    }

    public void returnMovie(Long id){
        String url = "localhost:8080/movies/{id/return}";
        restTemplate.put(url, null, id);
    }

}
