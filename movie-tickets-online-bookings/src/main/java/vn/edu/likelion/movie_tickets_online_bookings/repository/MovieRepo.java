package vn.edu.likelion.movie_tickets_online_bookings.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.edu.likelion.movie_tickets_online_bookings.entity.MovieEntity;

import java.util.Optional;

@Repository
public interface MovieRepo extends JpaRepository<MovieEntity, Integer> {
    Optional<MovieEntity> findByIdAndDeletedIsFalse(int id);
    Page<MovieEntity> findAllByDeleted(Pageable pageable, boolean isDeleted);
    Optional<MovieEntity> findByNameAndDeletedIsFalse(String name);
}
