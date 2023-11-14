package com.microserviceproject1.moviecatalogservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieCatalogService {

    @Autowired
    private MovieRatingService movieRatingService;

    @Autowired
    private MovieInfoService movieInfoService;

    @GetMapping
    public List<Movie> getAllMovies() {
        // Assuming you have a method to retrieve movies, replace the comment with actual logic
        List<Movie> movies = retrieveMoviesFromDatabaseOrService();

        // Set average ratings for each movie
        movies.forEach(movie -> movie.setAverageRating(movieRatingService.getAverageRating(movie.getId())));

        return movies;
    }

    @GetMapping("/{movieId}")
    public Movie getMovieDetails(@PathVariable String movieId) {
        // Assuming you have a method to retrieve movie details, replace the comment with actual logic
        Movie movie = retrieveMovieDetailsFromDatabaseOrService(movieId);

        // Set average rating and additional info for the movie
        movie.setAverageRating(movieRatingService.getAverageRating(movieId));
        movie.setAdditionalInfo(movieInfoService.getMovieInfo(movieId));

        return movie;
    }

    // Replace the following methods with actual implementations based on your data access strategy

    private List<Movie> retrieveMoviesFromDatabaseOrService() {
        // Implement logic to retrieve movies (e.g., from a database or external service)
        // Return a list of Movie objects
        return null;
    }

    private Movie retrieveMovieDetailsFromDatabaseOrService(String movieId) {
        // Implement logic to retrieve movie details for the given movieId
        // Return a Movie object
        return null;
    }
}
