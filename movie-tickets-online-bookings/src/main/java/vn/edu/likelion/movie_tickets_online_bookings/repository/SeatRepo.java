package vn.edu.likelion.movie_tickets_online_bookings.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.edu.likelion.movie_tickets_online_bookings.entity.SeatEntity;

@Repository
public interface SeatRepo extends JpaRepository<SeatEntity, Integer> {
}
