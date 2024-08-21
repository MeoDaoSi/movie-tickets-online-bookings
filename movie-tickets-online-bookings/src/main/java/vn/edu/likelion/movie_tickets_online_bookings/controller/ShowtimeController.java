package vn.edu.likelion.movie_tickets_online_bookings.controller;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.edu.likelion.movie_tickets_online_bookings.dto.request.ShowtimeRequest;
import vn.edu.likelion.movie_tickets_online_bookings.dto.response.ShowtimeResponse;
import vn.edu.likelion.movie_tickets_online_bookings.service.ShowtimeService;

@RestController
@RequestMapping("/api/showtimes")
@AllArgsConstructor
@CrossOrigin("*")
public class ShowtimeController {

    @Autowired
    ShowtimeService showtimeService;

    @PostMapping("/{movie_id}")
    private ResponseEntity<ShowtimeResponse> addShowtime(@PathVariable int movie_id,
                                                        @RequestBody ShowtimeRequest showtimeRequest ){
        ShowtimeResponse showtimeResponse = showtimeService.createShowtime(movie_id, showtimeRequest);
        System.out.println(showtimeResponse);
        return new ResponseEntity<>(showtimeResponse, HttpStatus.CREATED);
    }

    @GetMapping("/{showtime_id}")
    private ResponseEntity<ShowtimeResponse> findShowtimeById(@PathVariable int showtime_id){
        ShowtimeResponse showtimeResponse = showtimeService.findById(showtime_id);
        System.out.println(showtimeResponse);
        return new ResponseEntity<>(showtimeResponse, HttpStatus.OK);
    }
}
