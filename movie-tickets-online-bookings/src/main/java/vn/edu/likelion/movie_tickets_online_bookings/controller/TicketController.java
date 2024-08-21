package vn.edu.likelion.movie_tickets_online_bookings.controller;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.edu.likelion.movie_tickets_online_bookings.dto.request.TicketRequest;
import vn.edu.likelion.movie_tickets_online_bookings.dto.response.TicketResponse;
import vn.edu.likelion.movie_tickets_online_bookings.service.TicketService;

@RestController
@RequestMapping("/api/tickets")
@AllArgsConstructor
@CrossOrigin("*")
public class TicketController {

    @Autowired
    TicketService ticketService;

    @PostMapping("/{movie_id}")
    private ResponseEntity<TicketResponse> bookingTicket(@PathVariable int movie_id,
                                                         @RequestBody TicketRequest ticketRequest ){
        TicketResponse ticketResponse = ticketService.createTicket(movie_id, ticketRequest);
        System.out.println(ticketResponse);
        return new ResponseEntity<>(ticketResponse, HttpStatus.CREATED);
    }

    @GetMapping("/{ticket_id}")
    private ResponseEntity<TicketResponse> findShowtimeById(@PathVariable int ticket_id){
        TicketResponse ticketResponse = ticketService.findById(ticket_id);
        System.out.println(ticketResponse);
        return new ResponseEntity<>(ticketResponse, HttpStatus.OK);
    }
}
