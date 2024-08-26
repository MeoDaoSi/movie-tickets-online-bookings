package vn.edu.likelion.movie_tickets_online_bookings.service;

import vn.edu.likelion.movie_tickets_online_bookings.dto.request.TicketRequest;
import vn.edu.likelion.movie_tickets_online_bookings.dto.response.ShowtimeResponse;
import vn.edu.likelion.movie_tickets_online_bookings.dto.response.TicketResponse;

public interface TicketService extends BaseService<TicketRequest, TicketResponse>{
    TicketResponse createTicket(int movie_id, TicketRequest ticketRequest);
}
