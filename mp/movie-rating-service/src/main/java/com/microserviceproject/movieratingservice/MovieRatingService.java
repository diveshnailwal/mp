package com.microserviceproject.movieratingservice;

import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/ratings")
public class MovieRatingService {

    private Map<String, List<Integer>> ratings = new HashMap<>();

    @PostMapping("/{movieId}")
    public void rateMovie(@PathVariable String movieId, @RequestBody Integer rating) {
        ratings.computeIfAbsent(movieId, k -> new ArrayList<>()).add(rating);
    }

    @GetMapping("/{movieId}")
    public Double getAverageRating(@PathVariable String movieId) {
        List<Integer> movieRatings = ratings.getOrDefault(movieId, Collections.emptyList());
        if (movieRatings.isEmpty()) {
            return 0.0;
        }
        return movieRatings.stream().mapToDouble(Integer::doubleValue).average().orElse(0.0);
    }
}
