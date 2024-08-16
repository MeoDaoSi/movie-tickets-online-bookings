package vn.edu.likelion.movie_tickets_online_bookings.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.edu.likelion.movie_tickets_online_bookings.dto.request.MovieRequestDTO;
import vn.edu.likelion.movie_tickets_online_bookings.dto.response.MovieResponseDTO;
import vn.edu.likelion.movie_tickets_online_bookings.service.MovieService;

import java.util.List;

@RestController
@RequestMapping("/api/movies")
public class MovieController {

    private final MovieService movieService;

    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    // Create a new movie
    @PostMapping("/create")
    public ResponseEntity<MovieResponseDTO> createMovie(@RequestBody MovieRequestDTO movieRequestDTO) {
        MovieResponseDTO createdMovie = movieService.create(movieRequestDTO);
        return ResponseEntity.ok(createdMovie);
    }

    // Retrieve a specific movie by ID
    @GetMapping("/findById/{id}")
    public ResponseEntity<MovieResponseDTO> getMovieById(@PathVariable int id) {
        MovieResponseDTO movie = movieService.findById(id);
        return ResponseEntity.ok(movie);
    }

    // Retrieve all movies with pagination, sorting, and deleted status filtering
    @GetMapping("/findAll")
    public ResponseEntity<List<MovieResponseDTO>> getAllMovies(
            @RequestParam(value = "status", required = false, defaultValue = "false") boolean statusInDBOfMovie,
            @RequestParam(value = "page", required = false, defaultValue = "0") int pageNo,
            @RequestParam(value = "size", required = false, defaultValue = "10") int pageSize,
            @RequestParam(value = "sortBy", required = false, defaultValue = "id") String sortBy,
            @RequestParam(value = "sortDir", required = false, defaultValue = "asc") String sortDir) {
        List<MovieResponseDTO> movies = movieService.findAll(statusInDBOfMovie, pageNo, pageSize, sortBy, sortDir);
        return ResponseEntity.ok(movies);
    }

    // Update an existing movie
    @PutMapping("/update/{id}")
    public ResponseEntity<MovieResponseDTO> updateMovie(@PathVariable int id, @RequestBody MovieRequestDTO movieRequestDTO) {
        MovieResponseDTO updatedMovie = movieService.update(movieRequestDTO, id);
        return ResponseEntity.ok(updatedMovie);
    }

    // Soft delete a movie by ID
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteMovie(@PathVariable int id) {
        movieService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
