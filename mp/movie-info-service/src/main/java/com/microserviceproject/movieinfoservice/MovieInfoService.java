package com.microserviceproject.movieinfoservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

// MovieInfoService.java
@RestController
@RequestMapping("/info")
public class MovieInfoService {

    private Map<String, String> movieInfo = new HashMap<>();

    @GetMapping("/{movieId}")
    public String getMovieInfo(@PathVariable String movieId) {
        return movieInfo.getOrDefault(movieId, "No additional information available.");
    }
}
