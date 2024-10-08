package vn.edu.likelion.movie_tickets_online_bookings.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.edu.likelion.movie_tickets_online_bookings.entity.ShowtimeEntity;

import java.util.Optional;

@Repository
public interface ShowtimeRepo extends JpaRepository<ShowtimeEntity, Integer> {

}
