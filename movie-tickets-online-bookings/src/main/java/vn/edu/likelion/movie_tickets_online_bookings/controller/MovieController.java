package vn.edu.likelion.movie_tickets_online_bookings.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/movie")
public class MovieController {
    @GetMapping("/find/{name}")
    public List<MovieDTO> findByName(@PathVariable String name) {

    }
}
