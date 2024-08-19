package vn.edu.likelion.movie_tickets_online_bookings.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.edu.likelion.movie_tickets_online_bookings.entity.HallEntity;

import java.util.Optional;

@Repository
public interface HallRepo extends JpaRepository<HallEntity, Integer> {
    Optional<HallEntity> findByIdAndIsDeletedFalse(int id);
    Page<HallEntity> findAllByIsDeleted(Pageable pageable, boolean isDeleted);
    Optional<HallEntity> findByName(String name);
}
