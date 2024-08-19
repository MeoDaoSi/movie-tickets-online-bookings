package vn.edu.likelion.movie_tickets_online_bookings.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.edu.likelion.movie_tickets_online_bookings.entity.MovieEntity;

import java.util.Optional;

@Repository
public interface MovieRepo extends JpaRepository<MovieEntity, Integer> {
    Optional<MovieEntity> findByIdAndIsDeletedFalse(int id);

    Page<MovieEntity> findAllByIsDeleted(Pageable pageable, boolean isDeleted);

    Optional<MovieEntity> findByName(String name);
}
