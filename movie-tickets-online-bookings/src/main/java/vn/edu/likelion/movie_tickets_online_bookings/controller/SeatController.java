package vn.edu.likelion.movie_tickets_online_bookings.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import vn.edu.likelion.movie_tickets_online_bookings.dto.request.SeatRequestDTO;
import vn.edu.likelion.movie_tickets_online_bookings.dto.response.SeatResponseDTO;
import vn.edu.likelion.movie_tickets_online_bookings.service.SeatService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/seats")
public class SeatController {

    private final SeatService seatService;

    @Autowired
    public SeatController(SeatService seatService) {
        this.seatService = seatService;
    }

    private ResponseEntity<Map<String, Object>> createResponse(String status, Object data, String message) {
        Map<String, Object> response = new HashMap<>();
        response.put("status", status);
        response.put("data", data);
        response.put("message", message);
        return ResponseEntity.ok(response);
    }

    // Create a new seat
    @PostMapping("/create")
    public ResponseEntity<Map<String, Object>> createSeat(@Validated @RequestBody SeatRequestDTO seatRequestDTO) {
        SeatResponseDTO createdSeat = seatService.create(seatRequestDTO);
        return createResponse("success", createdSeat, "Seat created successfully.");
    }

    // Retrieve a specific seat by ID
    @GetMapping("/findById/{id}")
    public ResponseEntity<Map<String, Object>> getSeatById(@Validated @PathVariable int id) {
        SeatResponseDTO seat = seatService.findById(id);
        return createResponse("success", seat, "Seat retrieved successfully.");
    }

    // Retrieve all seats
    @GetMapping("/findAll")
    public ResponseEntity<Map<String, Object>> getAllSeats() {
        List<SeatResponseDTO> seats = seatService.findAll();
        return createResponse("success", seats, "Seats retrieved successfully.");
    }

    // Update an existing seat
    @PutMapping("/update/{id}")
    public ResponseEntity<Map<String, Object>> updateSeat(@Validated @PathVariable int id, @RequestBody SeatRequestDTO seatRequestDTO) {
        SeatResponseDTO updatedSeat = seatService.update(seatRequestDTO, id);
        return createResponse("success", updatedSeat, "Seat updated successfully.");
    }

    // Delete a seat by ID
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Map<String, Object>> deleteSeat(@Validated @PathVariable int id) {
        seatService.delete(id);
        return createResponse("success", null, "Seat deleted successfully.");
    }

    // Retrieve all seats by hall ID
    @GetMapping("/findByHall/{hallId}")
    public ResponseEntity<Map<String, Object>> getAllSeatsByHall(@Validated @PathVariable int hallId) {
        List<SeatResponseDTO> seats = seatService.findAllByHall(hallId);
        return createResponse("success", seats, "Seats retrieved successfully.");
    }
}
