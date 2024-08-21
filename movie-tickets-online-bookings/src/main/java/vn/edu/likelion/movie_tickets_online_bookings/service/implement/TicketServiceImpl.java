package vn.edu.likelion.movie_tickets_online_bookings.service.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.likelion.movie_tickets_online_bookings.dto.request.TicketRequest;
import vn.edu.likelion.movie_tickets_online_bookings.dto.response.ShowtimeResponse;
import vn.edu.likelion.movie_tickets_online_bookings.dto.response.TicketResponse;
import vn.edu.likelion.movie_tickets_online_bookings.entity.SeatEntity;
import vn.edu.likelion.movie_tickets_online_bookings.entity.ShowtimeEntity;
import vn.edu.likelion.movie_tickets_online_bookings.entity.TicketEntity;
import vn.edu.likelion.movie_tickets_online_bookings.exception.SeatException;
import vn.edu.likelion.movie_tickets_online_bookings.exception.ShowtimeException;
import vn.edu.likelion.movie_tickets_online_bookings.exception.TicketException;
import vn.edu.likelion.movie_tickets_online_bookings.mapper.TicketMapper;
import vn.edu.likelion.movie_tickets_online_bookings.repository.SeatRepo;
import vn.edu.likelion.movie_tickets_online_bookings.repository.ShowtimeRepo;
import vn.edu.likelion.movie_tickets_online_bookings.repository.TicketRepo;
import vn.edu.likelion.movie_tickets_online_bookings.service.TicketService;

@Service
public class TicketServiceImpl implements TicketService {

    @Autowired
    TicketRepo ticketRepo;
    @Autowired
    ShowtimeRepo showtimeRepo;
    @Autowired
    SeatRepo seatRepo;
    @Autowired
    TicketMapper ticketMapper;

    @Override
    public TicketResponse create(TicketRequest ticketRequest) {
        return null;
    }

    @Override
    public TicketResponse createTicket(int movie_id, TicketRequest ticketRequest) {
        System.out.println(" ============= ticket service test ============= ");
        ShowtimeEntity showtimeEntity = showtimeRepo.findById(ticketRequest.getShowtime_id()).orElseThrow(
                () -> new ShowtimeException("Showtime not found ...!")
        );
        SeatEntity seatEntity = seatRepo.findById(ticketRequest.getSeat_id()).orElseThrow(
                () -> new SeatException("Seat not found ...!")
        );
        TicketEntity ticketEntity = ticketMapper.toEntity(ticketRequest);
        ticketEntity.setSeat(seatEntity);
        ticketEntity.setShowtime(showtimeEntity);

        ticketRepo.save(ticketEntity);

        return ticketMapper.toResponse(ticketEntity);
    }

    @Override
    public Iterable<TicketResponse> findAll(int pageNo, int pageSize, String sortBy, String sortDir) {
        return null;
    }

    @Override
    public TicketResponse update(TicketRequest ticketRequest) {
        return null;
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public TicketResponse findById(int id) {
        TicketEntity ticketEntity = ticketRepo.findById(id).orElseThrow(
                () -> new TicketException("Ticket not found ...!")
        );
        return ticketMapper.toResponse(ticketEntity);
    }
}
