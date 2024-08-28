package vn.edu.likelion.movie_tickets_online_bookings.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.edu.likelion.movie_tickets_online_bookings.entity.HallEntity;
import vn.edu.likelion.movie_tickets_online_bookings.entity.MovieEntity;

import java.util.List;
import java.util.Optional;

@Repository
public interface HallRepo extends JpaRepository<HallEntity, Integer> {
    Optional<HallEntity> findByIdAndDeletedIsFalse(int id);
    List<HallEntity> findAllByDeleted(boolean deleted, Sort sort);
    Optional<HallEntity> findByNameAndDeletedIsFalse(String name);
}
