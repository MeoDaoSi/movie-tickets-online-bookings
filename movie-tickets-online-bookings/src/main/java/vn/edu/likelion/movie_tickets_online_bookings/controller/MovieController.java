package vn.edu.likelion.movie_tickets_online_bookings.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import vn.edu.likelion.movie_tickets_online_bookings.dto.request.MovieRequestDTO;
import vn.edu.likelion.movie_tickets_online_bookings.dto.response.MovieResponseDTO;
import vn.edu.likelion.movie_tickets_online_bookings.service.MovieService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/movies")
@CrossOrigin
public class MovieController {

    private final MovieService movieService;

    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    private ResponseEntity<Map<String, Object>> createResponse(String status, Object data, String message) {
        Map<String, Object> response = new HashMap<>();
        response.put("status", status);
        response.put("data", data);
        response.put("message", message);
        return ResponseEntity.ok(response);
    }

    // Create a new movie
    @PostMapping("/create")
    public ResponseEntity<Map<String, Object>> createMovie(@Validated @RequestBody MovieRequestDTO movieRequestDTO) {
        MovieResponseDTO createdMovie = movieService.create(movieRequestDTO);
        return createResponse("success", createdMovie, "Movie created successfully.");
    }

    // Retrieve a specific movie by ID
    @GetMapping("/findById/{id}")
    public ResponseEntity<Map<String, Object>> getMovieById(@Validated @PathVariable int id) {
        MovieResponseDTO movie = movieService.findById(id);
        return createResponse("success", movie, "Movie retrieved successfully.");
    }

    // Retrieve all movies with pagination, sorting, and deleted status filtering
    @GetMapping("/findAll")
    public ResponseEntity<Map<String, Object>> getAllMovies(@Validated
                                                            @RequestParam(value = "status", required = false, defaultValue = "false") boolean statusInDBOfMovie,
                                                            @RequestParam(value = "page", required = false, defaultValue = "0") int pageNo,
                                                            @RequestParam(value = "size", required = false, defaultValue = "10") int pageSize,
                                                            @RequestParam(value = "sortBy", required = false, defaultValue = "id") String sortBy,
                                                            @RequestParam(value = "sortDir", required = false, defaultValue = "asc") String sortDir) {
        List<MovieResponseDTO> movies = movieService.findAll(statusInDBOfMovie, pageNo, pageSize, sortBy, sortDir);
        return createResponse("success", movies, "Movies retrieved successfully.");
    }

    // Update an existing movie
    @PutMapping("/update/{id}")
    public ResponseEntity<Map<String, Object>> updateMovie(@Validated @PathVariable int id, @RequestBody MovieRequestDTO movieRequestDTO) {
        MovieResponseDTO updatedMovie = movieService.update(movieRequestDTO, id);
        return createResponse("success", updatedMovie, "Movie updated successfully.");
    }

    // Soft delete a movie by ID
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Map<String, Object>> deleteMovie(@Validated @PathVariable int id) {
        movieService.delete(id);
        return createResponse("success", null, "Movie deleted successfully.");
    }
}